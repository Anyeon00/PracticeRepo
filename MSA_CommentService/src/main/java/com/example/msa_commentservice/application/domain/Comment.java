package com.example.msa_commentservice.application.domain;

import lombok.Getter;

@Getter
public class Comment {

    Long id;

    Long postId;

    String content;

    private Comment(final Long postId, final String content) {
        this.postId = postId;
        this.content = content;
    }

    private Comment(final Long id, final Long postId, final String content) {
        this.id = id;
        this.postId = postId;
        this.content = content;
    }

    public static Comment create(final Long postId, final String content) {
        return new Comment(postId, content);
    }

    public static Comment of(final Long id, final Long postId, final String content) {
        return new Comment(id, postId, content);
    }

}
