package kr.co.itresumeregistersite.domain.entity.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SignUpDto {    // 회원가입 Dto

    private String identity;

    private String password;

    private String checkPassword;

    private String name;

    private String phone;

    private String email;

    private String birth;

    private String address;

    private String gender;
}

