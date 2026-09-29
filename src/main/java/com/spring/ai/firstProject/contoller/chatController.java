package com.spring.ai.firstProject.contoller;





import com.spring.ai.firstProject.service.Chatservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class chatController {

    Chatservice chatService;

    chatController(Chatservice service) {
        chatService = service;
    }



    @GetMapping("/chat")
    private ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String message,
                                        @RequestHeader String userId) {

        String chat = chatService.chat(message, userId);

        return ResponseEntity.ok(chat);
    }
}
