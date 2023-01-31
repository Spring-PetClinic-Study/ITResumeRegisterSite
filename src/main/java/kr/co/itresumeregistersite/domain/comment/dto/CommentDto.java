package kr.co.itresumeregistersite.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentDto {

    private Long commentId;

    private String writer;

    private String comment;

    private LocalDateTime registerDate;
}
