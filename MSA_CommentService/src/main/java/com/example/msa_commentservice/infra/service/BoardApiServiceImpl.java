package com.example.msa_commentservice.infra.service;

import com.example.msa_commentservice.domain.port.out.BoardApiService;
import com.example.msa_commentservice.infra.external.feign.BoardApiServiceClient;
import com.example.msa_commentservice.infra.external.feign.dto.BoardCountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardApiServiceImpl implements BoardApiService {

    private final BoardApiServiceClient boardApiServiceClient;

    @Override
    public Long getBoardCount() {
        ResponseEntity<BoardCountResponse> response = boardApiServiceClient.getBoardCount();
        BoardCountResponse body = response.getBody();
        return body.boardCount();
    }
}
