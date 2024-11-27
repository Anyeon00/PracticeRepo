package com.example.msa_commentservice.presntation.external.api.request;

public record CommentPostRequest(
        Long postId,
        String content
) {
}
