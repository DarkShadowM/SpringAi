package com.spring.ai.firstProject.contoller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class chatController {

    private final ChatClient openAichatClient;
    private final ChatClient ollamaAichatClient;

    public chatController(OpenAiChatModel oepnaimodel, OllamaChatModel ollamaModel) {
        this.openAichatClient = ChatClient.builder(oepnaimodel).build();
        this.ollamaAichatClient = ChatClient.builder(ollamaModel).build();
    }

    @GetMapping("/chat")
    private ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String message) {

        var result = ollamaAichatClient.prompt(message).call().content();
        return ResponseEntity.ok(result);
    }
}
