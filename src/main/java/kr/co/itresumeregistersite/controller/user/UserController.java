package kr.co.itresumeregistersite.controller.user;

import kr.co.itresumeregistersite.domain.entity.user.dto.*;
import kr.co.itresumeregistersite.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    // 회원가입
    // uri : http://localhost:8080/users
    @PostMapping
    public void signUp(@RequestBody @Valid SignUpDto signUpDto) {
        userService.signUp(signUpDto);
    }

    // 로그인
    @PostMapping("/login")
    public void signIn(@RequestBody @Valid SignInDto signInDto) {
        userService.signIn(signInDto);
    }

    // 회원정보 조회
    @GetMapping
    public UserInfoDto userInfo(@RequestParam("identity") String identity) {
        return userService.userInfo(identity);
    }

    // 전체 회원정보 조회
    @GetMapping("/findAll")
    public List<UserInfoDto> findAllUserInfo() {
        return userService.findAllUserInfo();
    }

    // 회원정보 수정
    @PutMapping
    public void updateUser(@RequestBody @Valid UpdateDto updateDto) {
        userService.updateUser(updateDto);
    }

    // 회원 비밀번호 수정
    @PutMapping("/password")
    public void updatePassword(@RequestBody @Valid UpdatePasswordDto updatePasswordDto) {
        userService.updatePassword(updatePasswordDto);
    }

    // 회원탈퇴
    @DeleteMapping
    public void delete(@RequestBody @Valid DeleteDto deleteDto) {
        userService.delete(deleteDto);
    }
}
