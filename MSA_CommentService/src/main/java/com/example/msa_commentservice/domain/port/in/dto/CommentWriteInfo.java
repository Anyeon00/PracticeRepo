package com.example.msa_commentservice.domain.port.in.dto;

public record CommentWriteInfo(
        String content
) {
    public static CommentWriteInfo create(final String content) {
        return new CommentWriteInfo(content);
    }
}
