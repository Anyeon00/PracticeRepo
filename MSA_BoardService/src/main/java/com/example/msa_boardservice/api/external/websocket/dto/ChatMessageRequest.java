package com.example.msa_boardservice.api.external.websocket.dto;

public record ChatMessageRequest(
        String sender,
        String content
) {
}
