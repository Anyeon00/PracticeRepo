package com.example.msa_boardservice.presentation.external.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketServerConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    //초기 연결 설정 메서드
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        //오프닝 엔드포인트 설정
        //최초 연결 요청 URI -> ws://localhost:8080/websocket-connect
        registry.addEndpoint("/websocket-connect")
                //CORS 허용
                .setAllowedOrigins("*");
    }

    @Override
    // 발행 endpoint 와 구독 endpoint 관련 설정 메서드
    public void configureMessageBroker(MessageBrokerRegistry config) {

        //메시지 발행자가 전달할 채널의 prefix
        // ex) /chat 이라는 채널에 메시지 전달 -> /pub/chat
        config.setApplicationDestinationPrefixes("/pub");

        //구독자들이 구독할 채널의 prefix
        // ex) /chat 이라는 채널을 구독하려면 -> /sub/chat
        config.enableSimpleBroker("/sub");

        // /chat 이라는 url 은 컨트롤러의 @MessageMapping 에서 설정
    }
}
