package com.example.msa_commentservice.infra.repository.jpa;

import com.example.msa_commentservice.infra.repository.jpa.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentJpaRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByPostId(Long postId);
}
