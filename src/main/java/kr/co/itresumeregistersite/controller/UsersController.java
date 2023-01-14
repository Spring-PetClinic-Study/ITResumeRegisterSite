package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.usersDto.*;
import kr.co.itresumeregistersite.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UsersController {
    private final UsersService usersService;

    // 회원가입
    @PostMapping
    public void signUp(SignUpDto signUpDto) {
        usersService.signUp(signUpDto);
    }

    // 회원정보 조회
    @GetMapping
    public UsersInfoDto userInfo(String identity) {
        return usersService.userInfo(identity);
    }

    // 회원정보 수정
    @PutMapping
    public void updateUser(UsersUpdateDto usersUpdateDto) {
        usersService.updateUser(usersUpdateDto);
    }

    // 회원 비밀번호 수정
    @PutMapping("/password")
    public void updatePassword(UsersPasswordDto usersPasswordDto) {
        usersService.updatePassword(usersPasswordDto);
    }

    // 회원탈퇴
    @DeleteMapping
    public void delete(DeleteDto deleteDto) {
        usersService.delete(deleteDto);
    }
}
