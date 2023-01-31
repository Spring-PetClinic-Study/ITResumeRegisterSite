package kr.co.itresumeregistersite.domain.comment.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentDto {

    private String wirter;

    private String comment;

    private LocalDateTime registerDate;
}
