package kr.co.itresumeregistersite.domain.dto.boardsDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostSaveDto {

    private Long boardId;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime createdDate;
}
