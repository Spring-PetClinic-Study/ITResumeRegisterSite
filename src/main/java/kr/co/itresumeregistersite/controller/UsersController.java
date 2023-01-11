package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.usersDto.*;
import kr.co.itresumeregistersite.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    private UsersService usersService;

    // TODO URL 및 @Mapping 등 Http Method에 대한 공부

    // 회원가입
    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpDto signUpDto) throws Exception {
        usersService.signUp(signUpDto);
    }

    // 회원정보 조회
    @GetMapping()
    public ReadDto getUser(String identity) throws Exception {
        return usersService.getUser(identity);
    }

    // 회원정보 수정
    @PutMapping("/updateUser")
    public void updateUser(UsersUpdateDto usersUpdateDto) {
        usersService.updateUser(usersUpdateDto);
    }

    // 회원 비밀번호 수정
    @PutMapping("/updatePassword")
    public void updatePassword(UsersPasswordDto usersPasswordDto) throws Exception {
        usersService.updatePassword(usersPasswordDto);
    }

    // 회원탈퇴
    @DeleteMapping("/deleteUser")
    public void delete(DeleteDto deleteDto) {
        usersService.delete(deleteDto);
    }
}
