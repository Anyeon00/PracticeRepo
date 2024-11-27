package com.example.msa_boardservice.presentation.external.api.dto;

public record BoardPutRequest(
        String title,
        String content
) {
}
