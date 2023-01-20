package kr.co.itresumeregistersite.controller.user;

import kr.co.itresumeregistersite.domain.entity.user.dto.*;
import kr.co.itresumeregistersite.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping
    public void signUp(@RequestBody SignUpDto signUpDto) {
        userService.signUp(signUpDto);
    }

    // 회원정보 조회
    @GetMapping
    public UserInfoDto userInfo(@RequestParam String identity) {
        return userService.userInfo(identity);
    }

    // 전체 회원정보 조회
    @GetMapping("/findAll")
    public List<UserInfoDto> findAllUserInfo() {
        return userService.findAllUserInfo();
    }

    // 회원정보 수정
    @PutMapping
    public void updateUser(@RequestBody UpdateDto updateDto) {
        userService.updateUser(updateDto);
    }

    @PutMapping("/password")
    public void updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto) {
        userService.updatePassword(updatePasswordDto);
    }

    // 회원탈퇴
    @DeleteMapping
    public void delete(@RequestBody DeleteDto deleteDto) {
        userService.delete(deleteDto);
    }
}
