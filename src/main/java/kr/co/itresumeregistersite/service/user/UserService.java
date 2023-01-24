package kr.co.itresumeregistersite.service.user;

import kr.co.itresumeregistersite.domain.entity.user.User;
import kr.co.itresumeregistersite.domain.entity.user.dto.*;
import kr.co.itresumeregistersite.domain.exception.NoSuchDataException;
import kr.co.itresumeregistersite.domain.exception.NoSuchDataExceptionType;
import kr.co.itresumeregistersite.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    }

    // 회원정보 조회
    @Transactional(readOnly = true)
    public UserInfoDto userInfo(String identity) {
        User user = userRepository.findByIdentity(identity)
                .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        return User.of(user);
    }

    // 전체 회원정보 조회
    @Transactional(readOnly = true)
    public List<UserInfoDto> findAllUserInfo() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "users_id"))
                .stream()
                .map(User::of)
                .collect(Collectors.toList());
    }

    // 회원정보 수정
    @Transactional
    public void updateUser(UpdateDto updateDto) {
        User users = userRepository.findByIdentity(updateDto.getIdentity())
                .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        users.update(updateDto.getEmail(), updateDto.getPhone(), updateDto.getAddress());
    }

    // 회원 비밀번호 수정
    @Transactional
    public void updatePassword(UpdatePasswordDto updatePasswordDto) {
        User users = userRepository.findByIdentity(updatePasswordDto.getIdentity())
                .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        // 회원 비밀번호 동일 여부 검사
        changePassword(updatePasswordDto.getPassword(), updatePasswordDto.getChangePassword());

        users.updatePassword(updatePasswordDto.getPassword());
    }

    // 회원탈퇴
    @Transactional
    public void delete(DeleteDto deleteDto) {
        User users = userRepository.findByIdentity(deleteDto.getIdentity())
                .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        // 회원 비밀번호 동일 여부 검사
        checkPassword((deleteDto.getPassword()), deleteDto.getCheckPassword());

        userRepository.delete(users);
    }


    // 아이디 중복 검사
    private void checkIdentity(String identity){
        if (userRepository.findByIdentity(identity).isPresent())
            throw new NoSuchDataException(NoSuchDataExceptionType.ALREADY_EXIST_USERSIDENTITY);
    }

    // 비밀번호 확인 여부 검사
    private void checkPassword(String password, String checkPassword){
        if (!password.equals(checkPassword))
            throw new NoSuchDataException(NoSuchDataExceptionType.WRONG_PASSWORD);
    }

    // 비밀번호 일치 여부 검사
    public void changePassword(String password, String changePassword) {
        if (password.equals(changePassword))
            throw new NoSuchDataException(NoSuchDataExceptionType.WRONG_PASSWORD);
    }
}
