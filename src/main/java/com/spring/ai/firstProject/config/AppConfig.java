package com.spring.ai.firstProject.config;

import com.spring.ai.firstProject.advisor.TokenPrintAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {

        return chatClientBuilder
                .defaultAdvisors(new TokenPrintAdvisor(),new SimpleLoggerAdvisor())
                .defaultSystem("You are coding assistance, you are expert in coding")
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("gpt-4o-mini")
                        .temperature(0.3)
                        .maxTokens(200)

                )
                .build();
    }
}
