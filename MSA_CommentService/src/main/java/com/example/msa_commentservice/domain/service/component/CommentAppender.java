package com.example.msa_commentservice.domain.service.component;

import com.example.msa_commentservice.domain.port.out.CommentRepository;
import com.example.msa_commentservice.domain.domain.Comment;
import com.example.msa_commentservice.domain.port.in.dto.CommentWriteInfo;
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
