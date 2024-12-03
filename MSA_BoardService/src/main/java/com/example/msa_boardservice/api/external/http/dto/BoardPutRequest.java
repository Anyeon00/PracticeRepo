package com.example.msa_boardservice.api.external.http.dto;

public record BoardPutRequest(
        String title,
        String content
) {
}
