package com.example.msa_commentservice.presntation.external.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class JsonChatMessageController {

    @MessageMapping("/chat.{roomId}")   //  /pub/chat.1, /pub/chat.2, ... 으로 온 메시지 수신
    @SendTo("/sub/chat.{roomId}")   //  /sub/chat.1, /sub/chat.2, .. 구독자 에게 발송
    public ChatMessageDTO broadcastChatMessage(
            ChatMessageDTO chatMessageDTO,
            @DestinationVariable Long roomId) {
        return chatMessageDTO;
    }
}
