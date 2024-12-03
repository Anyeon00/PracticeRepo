package com.example.msa_boardservice.api.external.http;

import com.example.msa_boardservice.api.external.http.dto.BoardPostRequest;
import com.example.msa_boardservice.api.external.http.dto.BoardPutRequest;
import com.example.msa_boardservice.api.external.http.dto.BoardResponse;
import com.example.msa_boardservice.application.domain.Board;
import com.example.msa_boardservice.application.port.in.BoardUsecase;
import com.example.msa_boardservice.application.port.in.dto.BoardWriteInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardUsecase boardUsecase;

    @PostMapping
    public ResponseEntity<Long> postBoard(@RequestBody BoardPostRequest request) {
        Long written = boardUsecase.write(BoardWriteInfo.create(request.title(), request.content()));
        return ResponseEntity.ok(written);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponse> getBoard(@PathVariable Long boardId) {
        Optional<Board> board = boardUsecase.find(boardId);
        return ResponseEntity.ok(BoardResponse.of(board));
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<Long> putBoard(@PathVariable Long boardId, BoardPutRequest request) {
        Long updated = boardUsecase.update(boardId, BoardWriteInfo.create(request.title(), request.content()));
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long boardId) {
        boardUsecase.delete(boardId);
        return ResponseEntity.ok(null);
    }

//    @GetMapping("/commentCount")
//    public ResponseEntity<String> getPostCount() {
//        String postCountInfo = boardUsecase.callCommentCount();
//        return ResponseEntity.ok(postCountInfo);
//    }
}
