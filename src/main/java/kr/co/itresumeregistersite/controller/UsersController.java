package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.usersDto.*;
import kr.co.itresumeregistersite.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    private UsersService usersService;

    // 회원가입
    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpDto signUpDto) {

        usersService.checkUsersIdentityDuplication(signUpDto);
        usersService.checkUsersEmailDuplication(signUpDto);

        usersService.signUp(signUpDto);
    }

    // 회원정보 조회
    @GetMapping()
    public ReadDto getUser(String identity) {
        return usersService.getUser(identity);
    }

    // 회원정보 수정
    @PutMapping("/updateUser")
    public void updateUser(UsersUpdateDto updateDto) {
        usersService.updateUser(updateDto);
    }

    // 회원 비밀번호 수정
    @PutMapping("/updatePassword")
    public void updatePassword(UsersPasswordDto usersPasswordDto) {
        usersService.updatePassword(usersPasswordDto);
    }

    // 회원탈퇴
    @DeleteMapping("/deleteUser")
    public void deleteUser(DeleteDto deleteDto) {
        usersService.deleteUser(deleteDto);
    }
}
