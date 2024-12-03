package com.example.msa_boardservice.api.internal.http;

import com.example.msa_boardservice.application.service.BoardService;
import com.example.msa_boardservice.api.internal.http.dto.BoardCountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/api")
public class InternalApiController {

    private final BoardService boardService;

    @GetMapping("/boards/count")
    public ResponseEntity<BoardCountResponse> getBoardCount() {
        Long count = boardService.getAllCount();
        return ResponseEntity.ok(BoardCountResponse.of(count));
    }
}
