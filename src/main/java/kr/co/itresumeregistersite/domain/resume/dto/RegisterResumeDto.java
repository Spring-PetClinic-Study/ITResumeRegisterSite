package kr.co.itresumeregistersite.domain.resume.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class RegisterResumeDto {

    private Long resumeId;

    @NotBlank(message = "학교명을 입력해주세요")
    private String schoolName;

    @NotBlank(message = "지원하는 회사명을 입력해주세요")
    private String companyName;

    private String major;

    private String minor;

    @NotBlank(message = "자기소개서를 작성해주세요")
    @Size(max = 125, message = "자기소개서는 최대 125자까지 작성 가능합니다")
    private String profile;

    private LocalDateTime registerDate;
}
