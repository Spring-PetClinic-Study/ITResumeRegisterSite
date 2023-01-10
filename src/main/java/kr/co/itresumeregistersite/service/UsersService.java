package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.usersDto.*;
import kr.co.itresumeregistersite.domain.entity.Users;
import kr.co.itresumeregistersite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private UsersRepository usersRepository;

    // 회원가입
    @Transactional
    public void signUp(SignUpDto signUpDto) {
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

        usersRepository.save(users);
    }

    // 아아디 중복 여부 확인
    @Transactional
    public void checkUsersIdentityDuplication(SignUpDto signUpDto) {
        boolean usersIdentityDuplicate = usersRepository.existsByIdentity(signUpDto.getIdentity());

        if(usersIdentityDuplicate) {
            throw new IllegalStateException("이미 존재하는 아이디입니다!");
        }
    }

    // 이메일 중복 여부 확인
    @Transactional
    public void checkUsersEmailDuplication(SignUpDto signUpDto) {
        boolean usersEmailDuplicate = usersRepository.existsByEmail(signUpDto.getEmail());

        if(usersEmailDuplicate) {
            throw new IllegalStateException("이미 존재하는 이메일입니다!");
        }
    }


    // 전화번호 중복 여부 확인
    @Transactional
    public void checkUsersPhoneDuplication(SignUpDto signUpDto) {
        boolean usersPhoneDuplicate = usersRepository.existsByPhone(signUpDto.getPhone());

        if(usersPhoneDuplicate) {
            throw new IllegalStateException("이미 존재하는 전화번호입니다!");
        }
    }

    // 회원정보 조회
    public ReadDto getUser(String identity) {
        Optional<Users> users = usersRepository.findByIdentity(identity);
        ReadDto readDto = ReadDto.builder()
                .identity(users.get().getIdentity())
                .name(users.get().getName())
                .phone(users.get().getPhone())
                .email(users.get().getEmail())
                .birth(users.get().getBirth())
                .address(users.get().getAddress())
                .gender(users.get().getGender())
                .build();

        return readDto;
    }

    /// 회원정보 수정
    @Transactional
    public void updateUser(UsersUpdateDto usersUpdateDto) {
        Optional<Users> users = usersRepository.findByIdentity(usersUpdateDto.getIdentity());
        users.get().update(usersUpdateDto.getIdentity(),
                usersUpdateDto.getName(),
                usersUpdateDto.getPhone(),
                usersUpdateDto.getEmail(),
                usersUpdateDto.getBirth(),
                usersUpdateDto.getAddress(),
                usersUpdateDto.getGender());

        usersRepository.save(users.get());
    }

    // TODO 회원 비밀번호 수정
    @Transactional
    public void updatePassword(UsersPasswordDto usersPasswordDto) {
        Optional<Users> users = usersRepository.findByIdentity(usersPasswordDto.getIdentity());
        users.get().getPassword();

        usersRepository.save(users.get());
    }

    // 회원탈퇴
    @Transactional
    public void deleteUser(DeleteDto deleteDto) {
        Optional<Users> users = usersRepository.findByIdentity(deleteDto.getIdentity());
        usersRepository.delete(users.get());
    }
}
