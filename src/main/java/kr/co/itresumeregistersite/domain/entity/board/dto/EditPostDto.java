package kr.co.itresumeregistersite.domain.entity.board.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class EditPostDto {

    private Long boardId;

    @NotBlank(message = "제목을 작성해주세요")
    private String title;

    @NotBlank(message = "내용을 작성해주세요")
    private String content;
}
