package com.example.msa_commentservice.infra.external.feign;

import com.example.msa_commentservice.infra.external.feign.dto.BoardCountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "board-service", url = "${board-service.url}")
public interface BoardApiServiceClient {

    @GetMapping("/internal/api/boards/count")
    ResponseEntity<BoardCountResponse> getBoardCount();
}
