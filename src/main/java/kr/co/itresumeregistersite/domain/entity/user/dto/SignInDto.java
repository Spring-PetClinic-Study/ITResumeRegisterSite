package kr.co.itresumeregistersite.domain.entity.user.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class SignInDto {

    @NotBlank(message = "아이디를 입력해주세요")
    private String identity;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
}
