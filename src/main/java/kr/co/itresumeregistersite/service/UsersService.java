package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.usersDto.*;
import kr.co.itresumeregistersite.domain.entity.Users;
import kr.co.itresumeregistersite.domain.exception.usersException.NoSuchDataException;
import kr.co.itresumeregistersite.domain.exception.usersException.NoSuchDataExceptionType;
import kr.co.itresumeregistersite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService {

    /* TODO
        1. DB 연동
        2. docker 실행
        3. test 구현
        4. Postman 실행
        5. findAllUserInfo API 구현
     */

    private final UsersRepository usersRepository;

    // 회원가입
    @Transactional
    public void signUp(SignUpDto signUpDto) {
        // 아이디 중복 검사 및 비밀번호 재확인 검사
        checkIdentity(signUpDto.getIdentity());
        checkPassword(signUpDto.getPassword(), signUpDto.getCheckPassword());

        final Users users = Users.of(signUpDto);
        usersRepository.save(users);
    }

    // 회원 아이디 정보 조회
    @Transactional(readOnly = true)
    public UsersInfoDto userInfo(String identity) {
        Users users = usersRepository.findByIdentity(identity)
                .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        return Users.of(users);
    }

    // 전체 회원정보 조회
    @Transactional(readOnly = true)
    public List<UsersInfoDto> findAllUserInfo() {
        return usersRepository.findAll(Sort.by(Sort.Direction.ASC, "users_id")).stream()
                .map(Users::of)
                .collect(Collectors.toList());
    }

    // 회원정보 수정
    @Transactional
    public void updateUser(UsersUpdateDto usersUpdateDto) {
        Users users = usersRepository.findByIdentity(usersUpdateDto.getIdentity())
                .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        users.update(usersUpdateDto.getEmail(), usersUpdateDto.getPhone(), usersUpdateDto.getAddress());
    }

    // 회원 비밀번호 수정
    @Transactional
    public void updatePassword(UsersPasswordDto usersPasswordDto) {
        Users users = usersRepository.findByIdentity(usersPasswordDto.getIdentity())
                .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        // 회원 비밀번호 동일 여부 검사
        changePassword(usersPasswordDto.getPassword(), usersPasswordDto.getChangePassword());

        users.updatePassword(usersPasswordDto.getPassword());
    }

    // 회원탈퇴
    @Transactional
    public void delete(DeleteDto deleteDto) {
        Users users = usersRepository.findByIdentity(deleteDto.getIdentity())
                        .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_USERS));

        // 회원 비밀번호 동일 여부 검사
        checkPassword(deleteDto.getPassword(), deleteDto.getCheckPassword());

        usersRepository.delete(users);
    }


    // 아이디 중복 검사
    private void checkIdentity(String identity){
        if (usersRepository.findByIdentity(identity).isPresent())
            throw new NoSuchDataException(NoSuchDataExceptionType.ALREADY_EXIST_USERSIDENTITY);
    }

    // 비밀번호 확인 여부 검사
    private void checkPassword(String password, String checkPassword){
        if (!password.equals(checkPassword))
            throw new NoSuchDataException(NoSuchDataExceptionType.WRONG_PASSWORD);
    }

    // 비밀번호 일치 여부 검사
    private void changePassword(String password, String changePassword) {
        if (password.equals(changePassword))
            throw new NoSuchDataException(NoSuchDataExceptionType.WRONG_PASSWORD);
    }
}
