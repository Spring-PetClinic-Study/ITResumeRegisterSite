package kr.co.itresumeregistersite.domain.dto.usersDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReadDto {

    private String identity;

    private String name;

    private String phone;

    private String email;

    private String birth;

    private String address;

    private String gender;

}

