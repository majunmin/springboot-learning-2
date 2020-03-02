package com.majm.elastic;

import com.majm.elastic.model.entity.Article;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticLearnApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void createDoc() {

        //1. 给ES中索引(保存)一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("张三");
        article.setContent("Hello World");


        IndexRequest indexRequest = new IndexRequest("bf").source(article.toHashMap());

        try {
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println(indexResponse.getResult().name());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() {
        GetRequest getRequest = new GetRequest("bf", "1");
        try {
            GetResponse documentFields = client.get(getRequest, RequestOptions.DEFAULT);
            System.out.println(documentFields.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchAll(){
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.from(100).size(100);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = null;
        try {
            searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            System.out.println(searchResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
