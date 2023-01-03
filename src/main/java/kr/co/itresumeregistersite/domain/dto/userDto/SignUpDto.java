package kr.co.itresumeregistersite.domain.dto.userDto;

import lombok.Getter;

@Getter
public class SignUpDto {

    private String identity;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String birth;
    private String address;
    private String gender;
}

