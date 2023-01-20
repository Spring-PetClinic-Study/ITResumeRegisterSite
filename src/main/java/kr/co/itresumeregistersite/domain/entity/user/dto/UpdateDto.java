package kr.co.itresumeregistersite.domain.entity.user.dto;

import lombok.Getter;

@Getter
public class UpdateDto {   // 회원정보 수정 Dto

    private String identity;

    private String name;

    private String phone;

    private String email;

    private String birth;

    private String address;

    private String gender;
}
