package com.example.msa_boardservice.api.internal.http.dto;

public record BoardCountResponse(
        Long boardCount
) {
    public static BoardCountResponse of(final Long boardCount) {
        return new BoardCountResponse(boardCount);
    }
}
