package kr.co.itresumeregistersite.domain.dto.boardDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DeletePostDto {

    private Long boardId;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;
}
