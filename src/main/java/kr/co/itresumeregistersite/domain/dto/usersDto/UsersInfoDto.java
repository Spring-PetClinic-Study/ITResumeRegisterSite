package kr.co.itresumeregistersite.domain.dto.usersDto;

import kr.co.itresumeregistersite.domain.entity.Users;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UsersInfoDto { // 회원조회 Dto

    private String name;

    private String email;

    private String birth;

    private String gender;

    @Builder
    public UsersInfoDto(Users users) {
        this.name = users.getName();
        this.email = users.getEmail();
        this.birth = users.getBirth();
        this.gender = users.getGender();
    }

}

