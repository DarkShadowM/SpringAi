package com.spring.ai.firstProject.service;



import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatserviceImpl implements Chatservice {
    @Override
    public String chat(String message) {

        return "";
    }

    @Override
    public String chatTemplate() {
        PromptTemplate strTemplate = PromptTemplate.builder().template("").build();
        return "";
    }
}
