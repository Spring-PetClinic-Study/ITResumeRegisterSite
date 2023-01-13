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

    // TODO URL 및 @Mapping 등 Http Method에 대한 공부

    // 회원가입
    @PostMapping
    public void signUp(@RequestBody SignUpDto signUpDto) {
        usersService.signUp(signUpDto);
    }

    // 회원정보 조회
    @GetMapping
    public UsersInfoDto userInfo(String name) {
        return usersService.userInfo(name);
    }

    // 회원정보 수정
    @PutMapping
    public void updateUser(UsersUpdateDto usersUpdateDto) {
        usersService.updateUser(usersUpdateDto);
    }

    // TODO URL이 왜 겹치면 안뙤는지 이해하기
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
