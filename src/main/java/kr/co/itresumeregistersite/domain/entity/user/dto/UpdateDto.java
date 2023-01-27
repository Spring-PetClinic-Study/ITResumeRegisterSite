package kr.co.itresumeregistersite.domain.entity.user.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class UpdateDto {   // 회원정보 수정 Dto

    @NotBlank(message = "아이디를 입력해주세요")
    @Size(min = 5, max = 15, message = "ID는 5~15자로 입력해주세요")
    private String identity;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 4, max = 15, message = "PW는 4~15자로 입력해주세요")
    private String password;

    private String phone;

    @Email
    private String email;

    private String birth;

    private String address;

    private String gender;
}
