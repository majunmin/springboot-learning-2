//
//package com.majm.elastic.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.FactoryBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//public class ElasticsearchConfiguration implements FactoryBean<RestHighLevelClient>, InitializingBean, DisposableBean {
//
//    @Value("${spring.data.elasticsearch.host}")
//    private String host;
//    @Value("${spring.data.elasticsearch.port}")
//    private int port;
//    @Value("${spring.data.elasticsearch.username}")
//    private String username;
//    @Value("${spring.data.elasticsearch.password}")
//    private String password;
//
//    private RestHighLevelClient restHighLevelClient;
//
//    @Override
//    public void destroy() throws Exception {
//        try {
//            log.info("Closing elasticSearch client");
//            if (restHighLevelClient != null) {
//                restHighLevelClient.close();
//            }
//        } catch (final Exception e) {
//            log.error("Error closing ElasticSearch client: ", e);
//        }
//    }
//
//    @Override
//    public RestHighLevelClient getObject() throws Exception {
//        return restHighLevelClient;
//    }
//
//    @Override
//    public Class<RestHighLevelClient> getObjectType() {
//        return RestHighLevelClient.class;
//    }
//
//    @Override
//    public boolean isSingleton() {
//        return false;
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        buildClient();
//    }
//
//    protected void buildClient() {
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
//        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port))
//                .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
//                    @Override
//                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
//                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//                    }
//                });
//
//        restHighLevelClient = new RestHighLevelClient(builder);
//    }
//
//}