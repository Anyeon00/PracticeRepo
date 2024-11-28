package com.example.msa_boardservice.presentation.external.socket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    @MessageMapping("/chat")    // /chat 채널 명   _/pub/chat 으로 발행된 메시지 처리
    @SendTo("/sub/chat")    // /chat 을 구독한 사용자에게 전달
    public ChatMessageResponse sendMessage(ChatMessageRequest request) {
        //DTO : ChatMessageRequest _JSON 타입 메시지 요청, DTO 로 자동 직렬화

        return new ChatMessageResponse(request.sender(), request.content());
    }
    //chat 이라는 채널을 쓴다고 가정
    //보내는 쪽은 /pub/chat 으로 보냄
    //받는 쪽은 /sub/chat 을 구독
}
