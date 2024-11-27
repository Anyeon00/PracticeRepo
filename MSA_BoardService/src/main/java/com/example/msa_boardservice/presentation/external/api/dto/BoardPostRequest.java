package com.example.msa_boardservice.presentation.external.api.dto;

public record BoardPostRequest(
        String title,
        String content
) {
}
