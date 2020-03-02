package com.majm.elastic.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/3/1 7:15 下午
 * @since
 */
@Data
public class Article implements Serializable {

    private Integer id;
    private String author;
    private String title;
    private String content;

    public Map<String, Object> toHashMap(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", getId());
        hashMap.put("author", getAuthor());
        hashMap.put("title", getTitle());
        hashMap.put("content", getContent());
        return hashMap;
    }
}
