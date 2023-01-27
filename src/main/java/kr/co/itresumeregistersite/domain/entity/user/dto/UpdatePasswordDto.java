package kr.co.itresumeregistersite.domain.entity.user.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class UpdatePasswordDto { // 회원 비밀번호 수정 Dto

    private String identity;

    @NotBlank(message = "기존 비밀번호를 입력해주세요")
    private String password;

    @NotBlank(message = "변경할 비밀번호를 입력해주세요")
    @Size(min = 5, max = 15, message = "PW는 5~15자로 입력해주세요")
    private String changePassword;
}
