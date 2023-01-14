package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.usersDto.*;
import kr.co.itresumeregistersite.domain.entity.Users;
import kr.co.itresumeregistersite.domain.exception.usersException.UsersException;
import kr.co.itresumeregistersite.domain.exception.usersException.UsersExceptionType;
import kr.co.itresumeregistersite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersService {
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

    // 회원정보 조회
    @Transactional(readOnly = true)
    public UsersInfoDto userInfo(String identity) {
        Users users = usersRepository.findByIdentity(identity)
                .orElseThrow(() -> new  UsersException(UsersExceptionType.NOT_FOUND_USERS));

        return new UsersInfoDto(users.getName(), users.getEmail(), users.getBirth(), users.getGender());
    }

    // 회원정보 수정
    @Transactional
    public void updateUser(UsersUpdateDto usersUpdateDto) {
        Users users = usersRepository.findByIdentity(usersUpdateDto.getIdentity())
                .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));

        users.update(usersUpdateDto.getEmail(), usersUpdateDto.getPhone(), usersUpdateDto.getAddress());
    }

    // 회원 비밀번호 수정
    @Transactional
    public void updatePassword(UsersPasswordDto usersPasswordDto) {
        Users users = usersRepository.findByIdentity(usersPasswordDto.getIdentity())
                .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));

        // 회원 비밀번호 동일 여부 검사
        changePassword(usersPasswordDto.getPassword(), usersPasswordDto.getChangePassword());

        users.updatePassword(usersPasswordDto.getPassword());
    }

    // 회원탈퇴
    @Transactional
    public void delete(DeleteDto deleteDto) {
        Users users = usersRepository.findByIdentity(deleteDto.getIdentity())
                        .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));

        // 회원 비밀번호 동일 여부 검사
        checkPassword(deleteDto.getPassword(), deleteDto.getCheckPassword());

        usersRepository.delete(users);
    }



    private void checkIdentity(String identity){
        if (usersRepository.findByIdentity(identity).isPresent())
            throw new UsersException(UsersExceptionType.ALREADY_EXIST_USERSIDENTITY);
    }

    private void checkPassword(String password, String checkPassword){
        if (!password.equals(checkPassword))
            throw new UsersException(UsersExceptionType.WRONG_PASSWORD);
    }

    private void changePassword(String password, String changePassword) {
        if (password.equals(changePassword))
            throw new UsersException(UsersExceptionType.WRONG_PASSWORD);
    }
}
