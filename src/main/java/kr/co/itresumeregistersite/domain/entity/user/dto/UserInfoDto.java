package kr.co.itresumeregistersite.domain.entity.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserInfoDto { // 회원조회 Dto

    private String name;

    private String email;

    private String birth;

    private String gender;
}

