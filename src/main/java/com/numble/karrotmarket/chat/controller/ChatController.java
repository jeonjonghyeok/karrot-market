package com.numble.karrotmarket.chat.controller;

import com.numble.karrotmarket.common.argumentresolver.annotation.InjectUserId;
import com.numble.karrotmarket.common.config.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Message("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");

    }

    public void createChatRoom(Long productId, @InjectUserId Long buyerId) {
        // 없으면 새로 만듦
        // 상품_BuyerId -> Unique?

    }
}
