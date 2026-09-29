package com.spring.ai.firstProject.config;

import com.spring.ai.firstProject.advisor.TokenPrintAdvisor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;


@Configuration
public class AppConfig {

    @Value("classpath:/prompt/system.message.st")
    private Resource systemMessage;

    private Logger logger = LoggerFactory.getLogger(AppConfig.class);

    


    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder,ChatMemory chatMemory) {

        this.logger.info("Chat Memory Implementation class::"+chatMemory.getClass().getName());

        MessageChatMemoryAdvisor messageChatAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();


        return chatClientBuilder
                .defaultAdvisors(messageChatAdvisor,new SimpleLoggerAdvisor())
                .defaultSystem(systemMessage)
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("gpt-4o-mini")
                        .temperature(0.3)
                        .maxTokens(200)

                )
                .build();
    }
}
