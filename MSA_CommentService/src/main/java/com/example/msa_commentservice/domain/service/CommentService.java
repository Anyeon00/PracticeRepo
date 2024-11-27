package com.example.msa_commentservice.domain.service;

import com.example.msa_commentservice.domain.domain.Comment;
import com.example.msa_commentservice.domain.port.in.dto.CommentWriteInfo;
import com.example.msa_commentservice.domain.port.in.CommentUsecase;
import com.example.msa_commentservice.domain.port.out.BoardApiService;
import com.example.msa_commentservice.domain.service.component.CommentAppender;
import com.example.msa_commentservice.domain.service.component.CommentReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements CommentUsecase {

    private final BoardApiService boardApiService;
    private final CommentAppender commentAppender;
    private final CommentReader commentReader;

    @Override
    @Transactional
    public Long write(final Long postId, final CommentWriteInfo info) {
        return commentAppender.append(postId, info);
    }

    @Override
    public List<Comment> find(final Long postId) {
        return commentReader.read(postId);
    }

    @Override
    public Long update(Long commentId, CommentWriteInfo info) {
        return null;
    }

    @Override
    public Long delete(Long commentId) {
        return null;
    }

    @Override
    public String callBoardCount() {
        // postservice로부터 postcount 요청
        Long boardCount = boardApiService.getBoardCount();
        return "BoardService Response\n Board Count : " + boardCount;
    }

    @Override
    public Long getAllCount() {
        return commentReader.readCount();
    }
}
