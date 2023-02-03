package kr.co.itresumeregistersite.domain.resume.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ResumeInfoDto {

    private String schoolName;

    private String major;

    private String minor;

    private String profile;
}
