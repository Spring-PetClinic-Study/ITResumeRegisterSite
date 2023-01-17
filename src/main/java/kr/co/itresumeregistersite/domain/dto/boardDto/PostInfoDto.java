package kr.co.itresumeregistersite.domain.dto.boardDto;

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

    private String content;

    private String writer;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;
}
