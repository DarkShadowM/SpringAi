package com.spring.ai.firstProject.service;



import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatserviceImpl implements Chatservice {
    private static final Object DEFAULT_CONVERSATION_ID = "Conversation-";


    private final ChatClient openAichatClient;

    public ChatserviceImpl(ChatClient openAichatClient, JdbcChatMemoryRepository repository) {
        this.openAichatClient = openAichatClient;
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
}
