package kr.co.itresumeregistersite.domain.dto.usersDto;

import kr.co.itresumeregistersite.domain.entity.Users;
import lombok.Getter;

@Getter
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

    public Users toEntity() {
        return Users.builder()
                .identity(identity)
                .password(password)
                .name(name)
                .phone(phone)
                .email(email)
                .birth(birth)
                .address(address)
                .gender(gender)
                .build();
    }
}

