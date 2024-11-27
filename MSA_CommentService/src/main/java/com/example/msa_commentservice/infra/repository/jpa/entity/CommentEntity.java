package com.example.msa_commentservice.infra.repository.jpa.entity;

import com.example.msa_commentservice.domain.domain.Comment;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private Long postId;

    private String content;

    private CommentEntity(final Long postId, final String content) {
        this.postId = postId;
        this.content = content;
    }

    public static CommentEntity from(final Comment comment) {
        return new CommentEntity(comment.getPostId(), comment.getContent());
    }

    public Comment toModel() {
        return Comment.of(id, postId, content);
    }
}
