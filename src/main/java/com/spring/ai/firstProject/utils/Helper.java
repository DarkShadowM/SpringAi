package com.spring.ai.firstProject.utils;

import org.springframework.ai.document.Document;

import java.util.List;
import java.util.Map;

public class Helper {
    public static List<Document> documents = List.of(
            new Document("Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!!", Map.of("meta1", "meta1")),
            new Document("The World is Big and Salvation Lurks Around the Corner"),
            new Document("You walk forward facing the past and you turn back toward the future.", Map.of("meta2", "meta2")));

    public static List<Document>  getData(){
        return documents;
    }

}
