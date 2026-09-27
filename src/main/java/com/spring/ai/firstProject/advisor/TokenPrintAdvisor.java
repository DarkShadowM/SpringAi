package com.spring.ai.firstProject.advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisor;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisorChain;
import reactor.core.publisher.Flux;



public class TokenPrintAdvisor implements CallAdvisor, StreamAdvisor {

    private Logger logger = LoggerFactory.getLogger(TokenPrintAdvisor.class);
    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        this.logger.info("My token filter adviosr called ::"+chatClientRequest.toString());
        ChatClientResponse response = callAdvisorChain.nextCall(chatClientRequest);
        this.logger.info("My token filter adviosr called  with the response::"+response.toString());

        return response;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Flux<ChatClientResponse> adviseStream(ChatClientRequest chatClientRequest, StreamAdvisorChain streamAdvisorChain) {
        return null;
    }
}
