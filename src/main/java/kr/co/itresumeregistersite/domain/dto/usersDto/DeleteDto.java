package kr.co.itresumeregistersite.domain.dto.usersDto;

import lombok.Getter;

@Getter
public class DeleteDto {    // 회원탈퇴 Dto

    private String identity;

    private String password;
}
