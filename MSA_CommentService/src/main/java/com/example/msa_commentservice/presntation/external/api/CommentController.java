package com.example.msa_commentservice.presntation.external.api;

import com.example.msa_commentservice.presntation.external.api.request.CommentPostRequest;
import com.example.msa_commentservice.domain.domain.Comment;
import com.example.msa_commentservice.domain.port.in.dto.CommentWriteInfo;
import com.example.msa_commentservice.domain.port.in.CommentUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentUsecase commentUsecase;

    @PostMapping
    public ResponseEntity<Long> postComment(@RequestBody CommentPostRequest request) {
        Long postId = commentUsecase.write(request.postId(), CommentWriteInfo.create(request.content()));
        return ResponseEntity.ok(postId);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long boardId) {
        List<Comment> comments = commentUsecase.find(boardId);
        return ResponseEntity.ok(comments);
    }

    //board service에게 board count를 요청 _Feign Client 이용
    @GetMapping("/boardCount")
    public ResponseEntity<String> getPostCount() {
        String postCountInfo = commentUsecase.callBoardCount();
        return ResponseEntity.ok(postCountInfo);
    }
}
