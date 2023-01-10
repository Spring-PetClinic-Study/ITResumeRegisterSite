package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.usersDto.DeleteDto;
import kr.co.itresumeregistersite.domain.dto.usersDto.ReadDto;
import kr.co.itresumeregistersite.domain.dto.usersDto.SignUpDto;
import kr.co.itresumeregistersite.domain.dto.usersDto.UsersUpdateDto;
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
        Users user = Users.builder()
                .identity(signUpDto.getIdentity())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .phone(signUpDto.getPhone())
                .email(signUpDto.getEmail())
                .birth(signUpDto.getBirth())
                .address(signUpDto.getAddress())
                .gender(signUpDto.getGender())
                .build();

        usersRepository.save(user);
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

//    회원정보 조회
//    public ReadDto getUser(String identity) {
//        Optional<Users> user = userRepository.findById(identity);
//        ReadDto readDto = ReadDto.builder()
//                .identity(user.get().getIdentity())
//                .build();
//
//        return readDto;
//    }

    // 회원정보 수정
    @Transactional
    public void updateUser(UsersUpdateDto updateDto) {
        Optional<Users> user = usersRepository.findByIdentity(updateDto.getIdentity());
        user.get().update(updateDto.getIdentity(), updateDto.getName(), updateDto.getPhone(), updateDto.getEmail(), updateDto.getBirth(), updateDto.getAddress(), updateDto.getGender());

        usersRepository.save(user.get());
    }

    // 회원탈퇴
    @Transactional
    public void deleteUser(DeleteDto deleteDto) {
        Optional<Users> user = usersRepository.findByIdentity(deleteDto.getIdentity());
        usersRepository.delete(user.get());
    }

    // TODO 로그인

    // TODO 로그인을 하기 위해 가입된 user정보를 조회하는 메소드
}
