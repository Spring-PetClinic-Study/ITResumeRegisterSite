package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.usersDto.*;
import kr.co.itresumeregistersite.domain.entity.Users;
import kr.co.itresumeregistersite.domain.exception.NoSuchDataException;
import kr.co.itresumeregistersite.domain.exception.NoSuchDataExceptionType;
import kr.co.itresumeregistersite.repository.UserRepository;
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

    // 회원가입
    @Transactional
    public void signUp(SignUpDto signUpDto) {
        // 아이디 중복 검사 및 비밀번호 재확인 검사
        checkIdentity(signUpDto.getIdentity());
        checkPassword(signUpDto.getPassword(), signUpDto.getCheckPassword());

        final Users users = Users.of(signUpDto);
        userRepository.save(users);
    }

    // 회원정보 조회
    @Transactional(readOnly = true)
    public UsersInfoDto userInfo(String identity) {
        Users users = userRepository.findByIdentity(identity)
                .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        return Users.of(users);
    }

    // 전체 회원정보 조회
    @Transactional(readOnly = true)
    public List<UsersInfoDto> findAllUserInfo() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "users_id"))
                .stream()
                .map(Users::of)
                .collect(Collectors.toList());
    }

    // 회원정보 수정
    @Transactional
    public void updateUser(UsersUpdateDto usersUpdateDto) {
        Users users = userRepository.findByIdentity(usersUpdateDto.getIdentity())
                .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        users.update(usersUpdateDto.getEmail(), usersUpdateDto.getPhone(), usersUpdateDto.getAddress());
    }

    // 회원 비밀번호 수정
    @Transactional
    public void updatePassword(UsersPasswordDto usersPasswordDto) {
        Users users = userRepository.findByIdentity(usersPasswordDto.getIdentity())
                .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        // 회원 비밀번호 동일 여부 검사
        changePassword(usersPasswordDto.getPassword(), usersPasswordDto.getChangePassword());

        users.updatePassword(usersPasswordDto.getPassword());
    }

    // 회원탈퇴
    @Transactional
    public void delete(DeleteDto deleteDto) {
        Users users = userRepository.findByIdentity(deleteDto.getIdentity())
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
