package com.example.msa_commentservice.api.external.http.request;

public record CommentPostRequest(
        Long postId,
        String content
) {
}
