package com.example.msa_boardservice.infra.persistence.jpa.entity;

import com.example.msa_boardservice.application.domain.Board;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "boards")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    private BoardEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public static BoardEntity from(Board board) {
        return new BoardEntity(board.getTitle(), board.getContent());
    }

    public Board toModel() {
        return Board.create(id, title, content);
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
