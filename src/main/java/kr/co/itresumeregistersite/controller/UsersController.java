package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.usersDto.DeleteDto;
import kr.co.itresumeregistersite.domain.dto.usersDto.SignUpDto;
import kr.co.itresumeregistersite.domain.dto.usersDto.UsersUpdateDto;
import kr.co.itresumeregistersite.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    private UsersService usersService;

    // 회원가입
    @PostMapping("/user/signUp")
    public void signUp(@RequestBody SignUpDto signUpDto) {

        usersService.checkUsersIdentityDuplication(signUpDto);
        usersService.checkUsersEmailDuplication(signUpDto);
        usersService.checkUsersPhoneDuplication(signUpDto);

        usersService.signUp(signUpDto);
    }

//    회원정보 조회
//    @GetMapping("/user")
//    public ReadDto getUser(String identity) {
//        return userService.getUser(identity);
//    }

    // 회원정보 수정
    @PutMapping("/user/updateUser")
    public void updateUser(UsersUpdateDto updateDto) {
        usersService.updateUser(updateDto);
    }

    // 회원탈퇴
    @DeleteMapping("/user/deleteUser")
    public void deleteUser(DeleteDto deleteDto) {
        usersService.deleteUser(deleteDto);
    }

    // TODO 로그인

    // TODO 로그인을 하기 위해 가입된 user정보를 조회하는 메소드
}
