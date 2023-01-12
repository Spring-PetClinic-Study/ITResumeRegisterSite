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
    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpDto signUpDto) throws Exception {
        usersService.signUp(signUpDto);
    }

//    회원 로그인
//    public void signIn(SignInDto signInDto) throws Exception {
//        usersService.signIn(signInDto);
//    }

    // 회원정보 조회
    @GetMapping("")
    public UsersInfoDto userInfo(Long userId) throws Exception {
        return usersService.userInfo(userId);
    }

    // 회원정보 수정
    @PutMapping()
    public void updateUser(UsersUpdateDto usersUpdateDto) throws Exception {
        usersService.updateUser(usersUpdateDto);
    }

    // 회원 비밀번호 수정
    @PutMapping()
    public void updatePassword(UsersPasswordDto usersPasswordDto) throws Exception {
        usersService.updatePassword(usersPasswordDto);
    }

    // 회원탈퇴
    @DeleteMapping("/deleteUser")
    public void delete(DeleteDto deleteDto) throws Exception {
        usersService.delete(deleteDto);
    }
}
