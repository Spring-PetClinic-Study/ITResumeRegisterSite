package kr.co.itresumeregistersite.domain.dto.boardDto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@Getter
public class BoardDto {

    private String title;

    private String content;

    private String writer;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    @Builder
    public BoardDto(String title,
                    String content,
                    String writer,
                    LocalDateTime createdDate,
                    LocalDateTime modifiedDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
