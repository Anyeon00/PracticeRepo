package com.example.msa_commentservice.domain.port.out;

import com.example.msa_commentservice.domain.domain.Comment;

import java.util.List;

public interface CommentRepository {

    void save(Comment comment);

    List<Comment> findByPostId(Long postId);

    Long count();
}
