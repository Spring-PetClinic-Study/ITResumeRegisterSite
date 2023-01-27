package kr.co.itresumeregistersite.domain.entity.user.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class DeleteDto {    // 회원탈퇴 Dto

    private String identity;

    @NotBlank(message = "회원탈퇴를 위해 비밀번호를 입력해주세요")
    private String password;

    @NotBlank(message = "입력한 비밀번호를 다시 입력해주세요")
    private String checkPassword;
}
