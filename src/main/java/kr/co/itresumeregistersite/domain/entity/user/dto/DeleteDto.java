package kr.co.itresumeregistersite.domain.entity.user.dto;

import lombok.Getter;

@Getter
public class DeleteDto {    // 회원탈퇴 Dto

    private String identity;

    private String password;

    private String checkPassword;
}
