package kr.co.itresumeregistersite.domain.entity.board.dto;

import lombok.Getter;

@Getter
public class EditPostDto {

    private Long boardId;

    private String title;

    private String content;
}
