package com.example.msa_boardservice.presentation.external.socket;

public record ChatMessageRequest(
        String sender,
        String content
) {
}
