package kr.co.itresumeregistersite.domain.dto.usersDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

