package kr.co.itresumeregistersite.domain.dto.usersDto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReadDto {

    private String identity;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String birth;
    private String address;
    private String gender;

    @Builder
    public ReadDto(String identity, String password, String name, String phone, String email, String birth, String address, String gender) {
        this.identity = identity;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.address = address;
        this.gender = gender;
    }
}

