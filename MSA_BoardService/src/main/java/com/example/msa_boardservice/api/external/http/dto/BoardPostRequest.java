package com.example.msa_boardservice.api.external.http.dto;

public record BoardPostRequest(
        String title,
        String content
) {
}
