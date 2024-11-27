package com.example.msa_boardservice.presentation.internal.api.dto;

public record BoardCountResponse(
        Long boardCount
) {
    public static BoardCountResponse of(final Long boardCount) {
        return new BoardCountResponse(boardCount);
    }
}
