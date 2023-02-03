package kr.co.itresumeregistersite.domain.board.dto;

import kr.co.itresumeregistersite.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SavePostDto {

    @NotBlank(message = "제목을 작성해주세요")
    private String title;

    @NotBlank(message = "내용을 작성해주세요")
    private String content;

    @NotBlank(message = "작성자를 작성해주세요")
    private String writer;

    private LocalDateTime createdDate;

    private User user;
}
