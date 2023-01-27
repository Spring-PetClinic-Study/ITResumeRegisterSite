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
        // 새로 생성한 비밀번호와 확인 비밀번호와 일치하지 않을 경우 오류 발생
        checkPassword(signUpDto.getPassword(), signUpDto.getCheckPassword());

        final User user = User.of(signUpDto);

        userRepository.save(user);
        ResponseFormat.ok("signUp successfully completed");
    }

    // 로그인
    @Transactional(readOnly = true)
    public void signIn(SignInDto signInDto) {
        // 로그인 시 아이디, 비밀번호 입력 유무 검사
        doCheckLogIn(signInDto.getIdentity(), signInDto.getPassword());

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
        User user = userRepository.findByIdentity(updateDto.getIdentity())
                .orElseThrow(UserNotFoundException::new);

        // 회원정보 수정 시 로그인 검사
        doCheckLogIn(updateDto.getIdentity(), updateDto.getPassword());

        user.update(updateDto.getIdentity(),
                updateDto.getPhone(),
                updateDto.getEmail(),
                updateDto.getBirth(),
                updateDto.getAddress(),
                updateDto.getGender());

        userRepository.save(user);
        ResponseFormat.ok("updateUser successfully completed");
    }

    // 회원 비밀번호 수정
    @Transactional
    public void updatePassword(UpdatePasswordDto updatePasswordDto) {
        User user = userRepository.findByIdentity(updatePasswordDto.getIdentity())
                .orElseThrow(UserNotFoundException::new);

        // 회원 비밀번호 일치 여부 검사
        // 기존 비밀번호와 변경한 비밀번호가 서로 동일할 경우 오류 발생
        changePassword(updatePasswordDto.getPassword(), updatePasswordDto.getChangePassword());

        user.updatePassword(updatePasswordDto.getPassword());
        ResponseFormat.ok("updatePassword successfully completed");
    }

    // 회원탈퇴
    @Transactional
    public void delete(DeleteDto deleteDto) {
        User user = userRepository.findByIdentity(deleteDto.getIdentity())
                .orElseThrow(UserNotFoundException::new);

        // 회원 비밀번호 일치 여부 검사
        // 입력한 비밀번호가 현재 비밀번호와 일치하지 않으면 오류 발생
        checkPassword((deleteDto.getPassword()), deleteDto.getCheckPassword());

        userRepository.delete(user);
        ResponseFormat.ok("deleteUser successfully completed");
    }



    // 아이디 중복 검사
    private void checkIdentity(String identity){
        if (userRepository.findByIdentity(identity).isPresent())
            throw new DuplicatedCodeException();
    }

    // 회원가입 및 회원 비밀번호 수정 시 비밀번호 중복 여부 검사
    private void checkPassword(String password, String checkPassword){
        if (!password.equals(checkPassword))
            throw new WrongPasswordException();
    }

    // 회원탈퇴 시 비밀번호 일치 여부 검사
    public void changePassword(String password, String changePassword) {
        if (password.equals(changePassword))
            throw new WrongPasswordException();
    }

    // 로그인 상태 유무 확인
    public void doCheckLogIn(String identity, String password) {
        if (identity.isEmpty()) {
            throw new IdentityValueNullException();
        }
        if (password.isEmpty()) {
            throw new PasswordValueNullException();
        }
    }
}
