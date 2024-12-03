package com.example.msa_boardservice.infra.persistence;

import com.example.msa_boardservice.application.port.out.BoardRepository;
import com.example.msa_boardservice.application.domain.Board;
import com.example.msa_boardservice.application.port.in.dto.BoardWriteInfo;
import com.example.msa_boardservice.infra.persistence.jpa.entity.BoardEntity;
import com.example.msa_boardservice.infra.persistence.jpa.BoardJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    private final BoardJPARepository boardJPARepository;

    @Override
    public Long save(Board board) {
        BoardEntity save = boardJPARepository.save(BoardEntity.from(board));
        return save.getId();
    }

    @Override
    public Optional<Board> findById(Long boardId) {
        Optional<BoardEntity> found = boardJPARepository.findById(boardId);
        return found.map(BoardEntity::toModel);
    }

    @Override
    public Long update(Long boardId, BoardWriteInfo info) {
        boardJPARepository.findById(boardId).ifPresentOrElse(
                boardEntity -> boardEntity.update(info.title(), info.content()),
                () -> {
                    throw new RuntimeException("not found board");
                }
        );
        return boardId;
    }

    @Override
    public void delete(Long boardId) {
        boardJPARepository.findById(boardId).ifPresent(boardJPARepository::delete);
    }

    @Override
    public Long count() {
        return boardJPARepository.count();
    }
}
