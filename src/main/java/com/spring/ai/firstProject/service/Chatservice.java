package com.spring.ai.firstProject.service;

import java.util.List;

public interface Chatservice {

    public String chat(String message,String userId);
     public String chatTemplate();

     public String saveToVectorDb();
}
