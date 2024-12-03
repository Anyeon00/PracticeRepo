package com.example.msa_boardservice.application.service.component;

import com.example.msa_boardservice.application.domain.Board;
import com.example.msa_boardservice.application.port.out.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BoardReader {

    private final BoardRepository boardRepository;


    public Optional<Board> read(Long boardId) {
        return boardRepository.findById(boardId);
    }

    public Long readCount() {
        return boardRepository.count();
    }
}
