package com.example.chataigpt.service;

import com.example.chataigpt.ChatGPT;
import com.example.chataigpt.ChatGPTStream;
import com.example.chataigpt.ConsoleStreamListener;
import com.example.chataigpt.chat.ChatCompletion;
import com.example.chataigpt.chat.ChatCompletionResponse;
import com.example.chataigpt.chat.Message;
import com.example.chataigpt.util.Proxys;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.net.Proxy;
import java.util.Arrays;
import java.util.Collections;

@Service
public class ChatService {
    private ChatGPTStream chatGPTStream;
    @Resource
    private ChatGPT chatGPT;

    public String chat(String question) {
//        init();
        Proxy proxy = Proxys.http("127.0.0.1", 7777);
        chatGPT.setApiKey("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");
        chatGPT.setProxy(proxy);
        chatGPT.init();
        ChatCompletion chatCompletion = ChatCompletion.builder()
                .messages(Collections.singletonList(Message.of(question)))
                .build();
        ChatCompletionResponse response = chatGPT.chatCompletion(chatCompletion);
        return response.getChoices().get(0).getMessage().getContent();

    }


    private void init() {

        Proxy proxy = Proxys.http("127.0.0.1", 7777);

        chatGPTStream = ChatGPTStream.builder()
                .apiKey("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")
                .proxy(proxy)
                .timeout(600)
                .apiHost("https://api.openai.com/")
                .build()
                .init();
    }
}
