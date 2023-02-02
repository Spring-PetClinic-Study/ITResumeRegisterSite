package kr.co.itresumeregistersite.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RegisterCommentDto {

    private Long commentId;

    @NotBlank(message = "댓글 작성자를 입력해주세요")
    private String writer;

    @NotBlank(message = "댓글 내용을 입력해주세요")
    @Size(max = 125, message = "댓글은 최대 125자까지 가능합니다")
    private String comment;

    private LocalDateTime registerDate;
}
