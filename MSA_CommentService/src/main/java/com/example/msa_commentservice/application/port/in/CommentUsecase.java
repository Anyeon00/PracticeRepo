package com.example.msa_commentservice.application.port.in;

import com.example.msa_commentservice.application.domain.Comment;
import com.example.msa_commentservice.application.port.in.dto.CommentWriteInfo;

import java.util.List;

public interface CommentUsecase {
    //    댓글 작성, 조회, 수정, 삭제 API
//    특정 게시글에 달린 댓글 조회 API
    Long write(Long postId, CommentWriteInfo info);

    List<Comment> find(Long postId);

    Long update(Long commentId, CommentWriteInfo info);

    Long delete(Long commentId);

    //서비스간 통신 테스트
    String callBoardCount();

    Long getAllCount();
}
