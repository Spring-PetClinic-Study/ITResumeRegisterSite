package kr.co.itresumeregistersite.domain.dto.usersDto;

import lombok.Getter;

@Getter
public class UsersPasswordDto { // 회원 비밀번호 수정 Dto

    private String identity;

    private String password;

    private String changePassword;
}
