package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.usersDto.*;
import kr.co.itresumeregistersite.domain.entity.Users;
import kr.co.itresumeregistersite.domain.exception.usersException.UsersException;
import kr.co.itresumeregistersite.domain.exception.usersException.UsersExceptionType;
import kr.co.itresumeregistersite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

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
    public UsersInfoDto userInfo(String name) {
        Users users = usersRepository.findByName(name)
                .orElseThrow(() -> new  UsersException(UsersExceptionType.NOT_FOUND_USERS));

        return new UsersInfoDto(users.getName(), users.getEmail(), users.getBirth(), users.getGender());
    }

    // TODO 회원 목록 조회

    // 회원정보 수정
    @Transactional
    public void updateUser(UsersUpdateDto usersUpdateDto) {
        Users users = usersRepository.findByIdentity(usersUpdateDto.getIdentity())
                .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));

        users.update(usersUpdateDto.getEmail(), usersUpdateDto.getPhone(), usersUpdateDto.getAddress());
    }

    // TODO 회원 비밀번호 수정
    @Transactional
    public void updatePassword(UsersPasswordDto usersPasswordDto) {
        Users users = usersRepository.findByIdentity(usersPasswordDto.getIdentity())
                .orElseThrow(() -> new UsersException(UsersExceptionType.NOT_FOUND_USERS));

        // TODO 수정 전 비밀번호와 수정 후 비밀번호가 같을 경우 예외 처리 -> 예외처리 함수 사용
        if (usersPasswordDto.getPassword().equals(usersPasswordDto.getChangePassword())) {
            throw new UsersException(UsersExceptionType.WRONG_PASSWORD);
        }

        users.updatePassword(usersPasswordDto.getPassword());
    }

    // TODO 회원탈퇴
    @Transactional
    public void delete(DeleteDto deleteDto) {
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

    private void checkIdentity(String identity){
        if (usersRepository.findByIdentity(identity).isPresent())
            throw new UsersException(UsersExceptionType.ALREADY_EXIST_USERSIDENTITY);
    }

    private void checkPassword(String password, String checkPassword){
        if (!password.equals(checkPassword))
            throw new UsersException(UsersExceptionType.WRONG_PASSWORD);
    }
}
