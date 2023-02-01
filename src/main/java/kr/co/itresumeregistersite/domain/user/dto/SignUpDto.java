package kr.co.itresumeregistersite.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@Builder
public class SignUpDto {    // 회원가입 Dto

    @NotBlank(message = "아아디를 입력해주세요")
    @Size(min = 5, max = 15, message = "ID는 5~15자로 입력해주세요")
    private String identity;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 4, max = 15, message = "PW는 4~15자로 입력해주세요")
    private String password;

    @NotBlank(message = "입력한 비밀번호를 다시 입력해주세요")
    @Size(min = 4, max = 15, message = "비밀번호가 일치하지 않습니다")
    private String checkPassword;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    @NotBlank(message = "전화번호를 입력해주세요")
    private String phone;

    @NotBlank(message = "이메일을 입력해주세요")
    @Email
    private String email;

    @NotBlank(message = "생년월일을 입력해주세요")
    private String birth;

    @NotBlank(message = "주소를 입력해주세요")
    private String address;

    @NotBlank(message = "성별을 입력해주세요")
    private String gender;
}

