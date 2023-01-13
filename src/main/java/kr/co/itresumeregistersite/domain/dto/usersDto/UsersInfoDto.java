package kr.co.itresumeregistersite.domain.dto.usersDto;

import kr.co.itresumeregistersite.domain.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UsersInfoDto { // 회원조회 Dto

    private String name;

    private String email;

    private String birth;

    private String gender;

}

