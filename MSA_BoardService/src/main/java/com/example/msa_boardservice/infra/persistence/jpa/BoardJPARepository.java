package com.example.msa_boardservice.infra.persistence.jpa;

import com.example.msa_boardservice.infra.persistence.jpa.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJPARepository extends JpaRepository<BoardEntity, Long> {
}
