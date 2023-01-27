package kr.co.itresumeregistersite.domain.entity.user.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
public class UpdateDto {   // 회원정보 수정 Dto

    @Size(min = 5, max = 15, message = "ID는 5~15자로 입력해주세요")
    private String identity;

    private String phone;

    @Email
    private String email;

    private String address;

    private String gender;
}
