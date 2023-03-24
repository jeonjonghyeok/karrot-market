package com.numble.karrotmarket.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WebSocketTemplate {

    private static final String topicPrefix = "topic";

    private final SimpMessagingTemplate simpMessagingTemplate;

    public void sendMessage(final String topic, final Message message) {
        simpMessagingTemplate.convertAndSend(topicPrefix+topic, message);
    }

}
