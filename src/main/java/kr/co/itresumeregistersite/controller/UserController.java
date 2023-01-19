package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.usersDto.*;
import kr.co.itresumeregistersite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService usersService;

    // 회원가입
    @PostMapping
    public void signUp(@RequestBody SignUpDto signUpDto) {
        usersService.signUp(signUpDto);
    }

    // 회원정보 조회
    @GetMapping
    public UsersInfoDto userInfo(Long userId) {
        return usersService.userInfo(userId);
    }

    // 전체 회원정보 조회
    @GetMapping("/findAll")
    public List<UsersInfoDto> findAllUserInfo() {
        return usersService.findAllUserInfo();
    }

    // 회원정보 수정
    @PutMapping
    public void updateUser(UsersUpdateDto usersUpdateDto) {
        usersService.updateUser(usersUpdateDto);
    }

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
