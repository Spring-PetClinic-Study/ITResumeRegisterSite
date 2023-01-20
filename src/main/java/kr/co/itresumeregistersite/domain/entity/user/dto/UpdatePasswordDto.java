package kr.co.itresumeregistersite.domain.entity.user.dto;

import lombok.Getter;

@Getter
public class UpdatePasswordDto { // 회원 비밀번호 수정 Dto

    private String identity;

    private String password;

    private String changePassword;
}
