package kr.co.itresumeregistersite.service.user;

import kr.co.itresumeregistersite.domain.entity.user.User;
import kr.co.itresumeregistersite.domain.entity.user.dto.*;
import kr.co.itresumeregistersite.global.error.exception.user.*;
import kr.co.itresumeregistersite.global.error.response.ResponseFormat;
import kr.co.itresumeregistersite.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // test
    // 회원가입
    @Transactional
    public void signUp(SignUpDto signUpDto) {
        // 아이디 중복 검사 및 비밀번호 재확인 검사
        checkIdentity(signUpDto.getIdentity());
        checkPassword(signUpDto.getPassword(), signUpDto.getCheckPassword());

        final User user = User.of(signUpDto);
        userRepository.save(user);
        ResponseFormat.ok("signUp successfully completed");
    }

    // 로그인
    @Transactional(readOnly = true)
    public void signIn(SignInDto signInDto) {

        nullIdentity(signInDto.getIdentity());
        nullPassword(signInDto.getPassword());

        userRepository.findByIdentityAndPassword(signInDto.getIdentity(), signInDto.getPassword());
        ResponseFormat.ok("signIn successfully completed");
    }

    // 회원정보 조회
    @Transactional(readOnly = true)
    public UserInfoDto userInfo(String identity) {
        User user = userRepository.findByIdentity(identity)
                .orElseThrow(UserNotFoundException::new);

        return User.of(user);
    }

    // 전체 회원정보 조회
    @Transactional(readOnly = true)
    public List<UserInfoDto> findAllUserInfo() {
        return userRepository.findUserListBy();
    }

    // 회원정보 수정
    @Transactional
    public void updateUser(UpdateDto updateDto) {
        User users = userRepository.findByIdentity(updateDto.getIdentity())
                .orElseThrow(UserNotFoundException::new);

        users.update(updateDto.getIdentity(),
                updateDto.getEmail(),
                updateDto.getPhone(),
                updateDto.getAddress(),
                updateDto.getGender());
        ResponseFormat.ok("updateUser successfully completed");
    }

    // 회원 비밀번호 수정
    @Transactional
    public void updatePassword(UpdatePasswordDto updatePasswordDto) {
        User users = userRepository.findByIdentity(updatePasswordDto.getIdentity())
                .orElseThrow(UserNotFoundException::new);

        // 회원 비밀번호 동일 여부 검사
        changePassword(updatePasswordDto.getPassword(), updatePasswordDto.getChangePassword());

        users.updatePassword(updatePasswordDto.getPassword());
        ResponseFormat.ok("updatePassword successfully completed");
    }

    // 회원탈퇴
    @Transactional
    public void delete(DeleteDto deleteDto) {
        User users = userRepository.findByIdentity(deleteDto.getIdentity())
                .orElseThrow(UserNotFoundException::new);

        // 회원 비밀번호 동일 여부 검사
        checkPassword((deleteDto.getPassword()), deleteDto.getCheckPassword());

        userRepository.delete(users);
        ResponseFormat.ok("deleteUser successfully completed");
    }



    // 아이디 중복 검사
    private void checkIdentity(String identity){
        if (userRepository.findByIdentity(identity).isPresent())
            throw new DuplicatedCodeException();
    }

    // 비밀번호 확인 여부 검사
    private void checkPassword(String password, String checkPassword){
        if (!password.equals(checkPassword))
            throw new WrongPasswordException();

    }

    // 비밀번호 일치 여부 검사
    public void changePassword(String password, String changePassword) {
        if (password.equals(changePassword))
            throw new WrongPasswordException();
    }

    private void nullIdentity(String identity) {
        if(identity.isEmpty()) {
            throw new NullIdentityException();
        }
    }

    private void nullPassword(String password) {
        if(password.isEmpty()) {
            throw new NullPasswordException();
        }
    }
}
