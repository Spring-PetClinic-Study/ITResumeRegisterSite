package kr.co.itresumeregistersite.domain.user.controller;

import kr.co.itresumeregistersite.domain.user.dto.*;
import kr.co.itresumeregistersite.global.error.response.ResponseFormat;
import kr.co.itresumeregistersite.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // @Controller + @ResponseBody
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    // 회원가입
    // uri : http://localhost:8080/users
    @PostMapping
    public ResponseFormat signUp(@RequestBody @Valid SignUpDto signUpDto) {
        userService.signUp(signUpDto);
        return ResponseFormat.ok();
    }

    // 로그인
    @PostMapping("/login")
    public ResponseFormat signIn(@RequestBody @Valid SignInDto signInDto) {
        userService.signIn(signInDto);
        return ResponseFormat.ok();
    }

    // 회원정보 조회
    @GetMapping
    public ResponseFormat userInfo(@RequestParam("identity") String identity) {
        userService.userInfo(identity);
        return ResponseFormat.ok();
    }

    // 전체 회원정보 조회
    @GetMapping("/findAll")
    public List<UserInfoDto> findAllUserInfo() {
        return userService.findAllUserInfo();
    }

    // 회원정보 수정
    @PutMapping
    public ResponseFormat updateUser(@RequestBody @Valid UpdateDto updateDto) {
        userService.updateUser(updateDto);
        return ResponseFormat.ok();
    }

    // 회원 비밀번호 수정
    @PutMapping("/password")
    public ResponseFormat updatePassword(@RequestBody @Valid UpdatePasswordDto updatePasswordDto) {
        userService.updatePassword(updatePasswordDto);
        return ResponseFormat.ok();
    }

    // 회원탈퇴
    @DeleteMapping
    public ResponseFormat delete(@RequestBody @Valid DeleteDto deleteDto) {
        userService.delete(deleteDto);
        return ResponseFormat.ok();
    }
}
