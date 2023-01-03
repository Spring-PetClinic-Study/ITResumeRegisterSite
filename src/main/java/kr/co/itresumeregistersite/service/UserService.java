package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.userDto.SignUpDto;
import kr.co.itresumeregistersite.domain.entity.User;
import kr.co.itresumeregistersite.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private UserRepository userRepository;

    // TODO 회원가입
    public void signUp(SignUpDto signUpDto) {
        User user = User.builder()
                .identity(signUpDto.getIdentity())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .phone(signUpDto.getPhone())
                .email(signUpDto.getEmail())
                .birth(signUpDto.getBirth())
                .address(signUpDto.getAddress())
                .gender(signUpDto.getGender())
                .build();

        userRepository.save(user);
    }
}
