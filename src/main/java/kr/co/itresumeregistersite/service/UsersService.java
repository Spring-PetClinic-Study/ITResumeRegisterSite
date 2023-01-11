package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.usersDto.*;
import kr.co.itresumeregistersite.domain.entity.Users;
import kr.co.itresumeregistersite.domain.exception.UsersException;
import kr.co.itresumeregistersite.domain.exception.UsersExceptionType;
import kr.co.itresumeregistersite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private UsersRepository usersRepository;


    // TODO Spring Security(PasswordEncoder)에 대해 공부 -> 개어려움
    // TODO UsersServiceImpl implements UsersService 하는 이유에 대해 공부
    // 회원가입
    @Transactional
    public void signUp(SignUpDto signUpDto) throws Exception{
        Users users = Users.builder()
                .identity(signUpDto.getIdentity())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .phone(signUpDto.getPhone())
                .email(signUpDto.getEmail())
                .birth(signUpDto.getBirth())
                .address(signUpDto.getAddress())
                .gender(signUpDto.getGender())
                .build();

        // 아이디 중복 검사
        if (usersRepository.findByIdentity(signUpDto.getIdentity()).isPresent()) {
            throw new UsersException(UsersExceptionType.ALREADY_EXIST_USERSIDENTITY);
        }

        usersRepository.save(users);
    }

//    회원 로그인
//    아이디, 비밀번호가 틀렸을 경우 예외 처리
//    public void signIn(SignInDto signInDto) throws Exception {
//
//    }

    // TODO 일치하는 회원정보가 없을 경우 예외 처리
    // 회원정보 조회
    public UsersInfoDto getUser(String identity) throws Exception {
        Users users = usersRepository.findByIdentity(identity)
                .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));


    }

    // 회원정보 수정
    @Transactional
    public void updateUser(UsersUpdateDto usersUpdateDto) throws Exception {
        Users users = usersRepository.findByIdentity(usersUpdateDto.getIdentity())
                .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));

        users.update(usersUpdateDto.getEmail(), usersUpdateDto.getPhone(), usersUpdateDto.getAddress());
    }

    // 수정 전 비밀번호와 수정 후 비밀번호가 같을 경우 예외 처리
    // 회원 비밀번호 수정
    @Transactional
    public void updatePassword(UsersPasswordDto usersPasswordDto) throws Exception {
        Users users = usersRepository.findByIdentity(usersPasswordDto.getIdentity())
                .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));


        if (usersPasswordDto.getPassword().equals(usersPasswordDto.getChangePassword())) {
            throw new UsersException(UsersExceptionType.WRONG_PASSWORD);
        }

        users.updatePassword(usersPasswordDto.getPassword());
    }

    // 회원탈퇴
    @Transactional
    public void delete(DeleteDto deleteDto) {
        Optional<Users> users = usersRepository.findByIdentity(deleteDto.getIdentity());
        usersRepository.delete(users.get());
    }
}
