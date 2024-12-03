package com.example.msa_boardservice.api.external.websocket.dto;

public record ChatMessageResponse(

        String sender,
        String content

) {
}
