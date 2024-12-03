package com.example.msa_boardservice.api.external.http.dto;

import com.example.msa_boardservice.application.domain.Board;

import java.util.Optional;

public record BoardResponse(
        Optional<Board> board
) {
    public static BoardResponse of(Optional<Board> board) {
        return new BoardResponse(board);
    }
}
