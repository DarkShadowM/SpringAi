package com.spring.ai.firstProject.service;

import com.spring.ai.firstProject.utils.Helper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChatserviceImpl implements Chatservice {
    private static final Object DEFAULT_CONVERSATION_ID = "Conversation-";


    private VectorStore store;

    private final ChatClient openAichatClient;

    public ChatserviceImpl(ChatClient openAichatClient,VectorStore store) {
        this.openAichatClient = openAichatClient;
        this.store = store;
    }

    @Override
    public String chat(String message,String userId) {



        var result = openAichatClient.prompt()
                .user(message)
                .advisors(a -> a.param(
                        ChatMemory.CONVERSATION_ID,
                        userId
                ))
                .call()
                .content();
        return result;
    }

    @Override
    public String chatTemplate() {
        PromptTemplate strTemplate = PromptTemplate.builder().template("").build();
        return "";
    }

    @Override
    public String saveToVectorDb() {
        //List<Document> docList1 = list.stream().map(Document::new).toList();
        this.store.add(Helper.getData());
        return "";
    }
}
