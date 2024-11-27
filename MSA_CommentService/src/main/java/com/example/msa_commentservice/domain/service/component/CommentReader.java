package com.example.msa_commentservice.domain.service.component;

import com.example.msa_commentservice.domain.port.out.CommentRepository;
import com.example.msa_commentservice.domain.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentReader {

    private final CommentRepository commentRepository;


    public List<Comment> read(final Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public Long readCount() {
        return commentRepository.count();
    }
}