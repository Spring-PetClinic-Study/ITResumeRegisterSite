package kr.co.itresumeregistersite.domain.user.service;

import kr.co.itresumeregistersite.domain.user.dto.*;
import kr.co.itresumeregistersite.domain.user.entity.User;
import kr.co.itresumeregistersite.global.error.exception.user.*;
import kr.co.itresumeregistersite.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 회원가입
    @Transactional
    public void signUp(SignUpDto signUpDto) {

        duplicatedIdentity(signUpDto.getIdentity());
        notIdenticalPassword(signUpDto.getPassword(), signUpDto.getCheckPassword());

        final User user = User.of(signUpDto);

        userRepository.save(user);
    }

    // 로그인
    // TODO : login test error
    @Transactional(readOnly = true)
    public void signIn(SignInDto signInDto) {
        checkLogin(signInDto.getIdentity(), signInDto.getPassword());
    }

    // 회원정보 조회
    @Transactional(readOnly = true)
    public UserInfoDto userInfo(String identity) {
        User user = userRepository.findByIdentity(identity)
                .orElseThrow(NotFoundUserException::new);

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
                .orElseThrow(NotFoundUserException::new);

        notIdenticalPassword(updateDto.getPassword(), updateDto.getCheckPassword());

        user.update(updateDto.getIdentity(),
                updateDto.getPhone(),
                updateDto.getEmail(),
                updateDto.getBirth(),
                updateDto.getAddress(),
                updateDto.getGender());

        userRepository.save(user);
    }

    // 회원 비밀번호 수정
    @Transactional
    public void updatePassword(UpdatePasswordDto updatePasswordDto) {
        User user = userRepository.findByIdentity(updatePasswordDto.getIdentity())
                .orElseThrow(NotFoundUserException::new);

        // 회원 비밀번호 일치 여부 검사
        // 기존 비밀번호와 변경한 비밀번호가 서로 동일할 경우 오류 발생
        notIdenticalPassword(updatePasswordDto.getPassword(), updatePasswordDto.getChangePassword());

        user.updatePassword(updatePasswordDto.getPassword());
    }

    // 회원탈퇴
    @Transactional
    public void delete(DeleteDto deleteDto) {
        User user = userRepository.findByIdentity(deleteDto.getIdentity())
                .orElseThrow(NotFoundUserException::new);

        // 회원 비밀번호 일치 여부 검사
        // 입력한 비밀번호가 현재 비밀번호와 일치하지 않으면 오류 발생
        deleteInfoCheckPassword((deleteDto.getPassword()), deleteDto.getCheckPassword());

        userRepository.delete(user);
    }



    // 회원가입 시 아이디 중복 검사
    private void duplicatedIdentity(String identity){
        if (userRepository.existsByIdentity(identity))
            throw new DuplicatedCodeException();
    }

    // 회원가입 시 초기 비밀번호와 확인 비밀번호가 동일하지 않을 경우
    // 회원 비밀번호 수정 시 기존 비밀번호와 변경할 비밀번호가 동일하지 않을 경우
    // 회원정보 수정 시 기존 비밀번호와 입력한 비밀번호가 동일하지 않을 경우
    private void notIdenticalPassword(String password, String checkPassword){
        if (!password.equals(checkPassword))
            throw new NotExistPasswordException();
    }

    // 회원탈퇴 시 비밀번호 일치 여부 검사
    public void deleteInfoCheckPassword(String password, String changePassword) {
        if (password.equals(changePassword))
            throw new NotExistPasswordException();
    }

    // 로그인 여부 검사
    public void checkLogin(String identity, String password) {
        // 로그인 시 가입된 사용자의 아이디가 아닐 경우
        if (!userRepository.existsByIdentity(identity)) {
            throw new NotExistIdentityException();
        }
        if (!userRepository.existsByPassword(password)) {
            throw new NotExistPasswordException();
        }
    }
}
