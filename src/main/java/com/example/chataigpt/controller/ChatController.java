package com.example.chataigpt.controller;

import com.example.chataigpt.service.ChatService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Resource
    private ChatService chatService;

    @PostMapping("question")
    @ResponseBody
    public String question(@RequestParam("question") String question) {
        return chatService.chat(question);
    }
}
