package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.userDto.ReadDto;
import kr.co.itresumeregistersite.domain.dto.userDto.SignUpDto;
import kr.co.itresumeregistersite.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    private UserService userService;

    // TODO 회원가입
    @PostMapping("/user/signUp")
    public void signUp(@RequestBody SignUpDto signUpDto) {
        userService.signUp(signUpDto);
    }

    // TODO 로그인

    // TODO 회원정보 조회
    @GetMapping("/user")
    public ReadDto getUser(String identity) {
        return userService.getUser(identity);
    }

    // TODO 회원정보 수정

    // TODO 회원탈퇴
}
