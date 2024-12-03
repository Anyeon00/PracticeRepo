package com.example.msa_commentservice.application.service.component;

import com.example.msa_commentservice.application.port.out.CommentRepository;
import com.example.msa_commentservice.application.domain.Comment;
import com.example.msa_commentservice.application.port.in.dto.CommentWriteInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentAppender {
    private final CommentRepository commentRepository;


    public Long append(Long postId, CommentWriteInfo info) {
        commentRepository.save(
                Comment.create(
                        postId,
                        info.content()));
        return postId;
    }

}
