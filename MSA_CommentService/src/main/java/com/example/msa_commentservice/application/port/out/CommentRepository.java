package com.example.msa_commentservice.application.port.out;

import com.example.msa_commentservice.application.domain.Comment;

import java.util.List;

public interface CommentRepository {

    void save(Comment comment);

    List<Comment> findByPostId(Long postId);

    Long count();
}
