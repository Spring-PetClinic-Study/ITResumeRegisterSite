package kr.co.itresumeregistersite.domain.dto.usersDto;

import lombok.Getter;

@Getter
public class DeleteDto {    // 회원탈퇴 Dto

    private String identity;

    private String password;

    private String name;

    private String phone;

    private String email;

    private String birth;

    private String address;

    private String gender;
}
