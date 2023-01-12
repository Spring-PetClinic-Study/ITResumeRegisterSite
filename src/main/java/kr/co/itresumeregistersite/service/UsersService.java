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
    private final UsersRepository usersRepository;

    // 사용하기 위해서 Spring Security에 대해 자세하게 공부
//    private final PasswordEncoder passwordEncoder;


    // TODO Spring Security(PasswordEncoder)에 대해 공부 -> 개어려움
    // 회원가입
    @Transactional
    public void signUp(SignUpDto signUpDto) throws Exception {
        Users users = Users.builder()
                .identity(signUpDto.getIdentity())
                .password(signUpDto.getPassword())
                .checkPassword(signUpDto.getCheckPassword())
                .name(signUpDto.getName())
                .phone(signUpDto.getPhone())
                .email(signUpDto.getEmail())
                .birth(signUpDto.getBirth())
                .address(signUpDto.getAddress())
                .gender(signUpDto.getGender())
                .build();

        // 아이디 중복 검사 및 비밀번호 재확인 검사
        if (usersRepository.findByIdentity(signUpDto.getIdentity()).isPresent()) {
            throw new UsersException(UsersExceptionType.ALREADY_EXIST_USERSIDENTITY);
        }
        else if (!(signUpDto.getPassword().equals(signUpDto.getCheckPassword()))) {
            throw new UsersException(UsersExceptionType.WRONG_PASSWORD);
        }

        usersRepository.save(users);
    }

    // TODO 회원 로그인 -> Spring Security로 구현하는 방법도 공부

    // TODO 회원 로그아웃 -> SecurityContextHolder.clearContext()에 대해 공부

    // 회원정보 조회
    public UsersInfoDto userInfo(Long userId) throws Exception {
        // 일치하는 회원정보가 없을 경우 예외 처리
        Users users = usersRepository.findById(userId)
                .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));

        return new UsersInfoDto(users);
    }

    // 회원정보 수정
    @Transactional
    public void updateUser(UsersUpdateDto usersUpdateDto) throws Exception {
        Users users = usersRepository.findByIdentity(usersUpdateDto.getIdentity())
                .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));

        users.update(usersUpdateDto.getEmail(), usersUpdateDto.getPhone(), usersUpdateDto.getAddress());
    }

    @Transactional
    public void updatePassword(UsersPasswordDto usersPasswordDto) throws Exception {
        // 회원 비밀번호 수정
        Users users = usersRepository.findByIdentity(usersPasswordDto.getIdentity())
                .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));

        // 수정 전 비밀번호와 수정 후 비밀번호가 같을 경우 예외 처리
        if (usersPasswordDto.getPassword().equals(usersPasswordDto.getChangePassword())) {
            throw new UsersException(UsersExceptionType.WRONG_PASSWORD);
        }

        users.updatePassword(usersPasswordDto.getPassword());
    }

    // 회원탈퇴
    @Transactional
    public void delete(DeleteDto deleteDto) throws Exception {
        // TODO 회원탈퇴 시 아이디 또는 비밀번호(or 둘 다)를 입력받고 삭제, 틀릴 경우는 예외 처리
        Optional<Users> users = usersRepository.findByIdentity(deleteDto.getIdentity());

        String oldPassword = users.get().getPassword();
        String newPassword = deleteDto.getPassword();

        if (!(oldPassword.equals(newPassword))) {
            throw new UsersException(UsersExceptionType.WRONG_PASSWORD);
        }
        else {
            usersRepository.delete(users.get());
        }
    }
}
