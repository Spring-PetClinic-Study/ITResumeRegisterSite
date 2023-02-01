package kr.co.itresumeregistersite.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class PostInfoDto {

    private Long boardId;

    private String title;

    private String writer;

    private LocalDateTime createdDate;
}
