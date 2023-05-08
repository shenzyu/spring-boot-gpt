package com.example.chataigpt;

import com.example.chataigpt.service.ChatService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public  class ChatAiGptApplicationTests {

	@Resource
	private ChatService chatService;

	@Test
	public void contextLoads() {
		String question = "Java学习流程";
		System.out.println(chatService.chat(question));
	}

}
