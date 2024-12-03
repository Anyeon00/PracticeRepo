package com.example.msa_commentservice.infra.repository;

import com.example.msa_commentservice.application.port.out.CommentRepository;
import com.example.msa_commentservice.application.domain.Comment;
import com.example.msa_commentservice.infra.repository.jpa.CommentJpaRepository;
import com.example.msa_commentservice.infra.repository.jpa.entity.CommentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final CommentJpaRepository commentJpaRepository;

    @Override
    public void save(final Comment comment) {
        commentJpaRepository.save(CommentEntity.from(comment));
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        List<CommentEntity> comments = commentJpaRepository.findByPostId(postId);
        return comments.stream().map(CommentEntity::toModel).toList();
    }

    @Override
    public Long count() {
        return commentJpaRepository.count();
    }

}
