package kr.co.itresumeregistersite.domain.entity.user;

import kr.co.itresumeregistersite.domain.entity.user.dto.SignUpDto;
import kr.co.itresumeregistersite.domain.entity.user.dto.UserInfoDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
@Table(name = "tbl_users")
public class User {

    @Id @GeneratedValue
    @Column(name = "users_id")
    private Long usersId;   // primary Key

    @Column(length = 20, nullable = false, unique = true)
    private String identity;    // 아이디

    @Column(length = 20, nullable = false)
    private String password;    // 비밀번호

    @Column(length = 20, nullable = false)
    private String name;    // 이름

    @Column(length = 20, nullable = false, unique = true)
    private String phone;   // 전화번호

    @Column(length = 30, nullable = false, unique = true)
    private String email;   // 이메일

    @Column(length = 20, nullable = false)
    private String birth;   // 생일

    @Column(length = 30, nullable = false)
    private String address; // 주소

    @Column(length = 10, nullable = false)
    private String gender;  // 성별

    public static User of(SignUpDto signUpDto){
        return User.builder()
                .identity(signUpDto.getIdentity())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .phone(signUpDto.getPhone())
                .email(signUpDto.getEmail())
                .birth(signUpDto.getBirth())
                .address(signUpDto.getAddress())
                .gender(signUpDto.getGender())
                .build();
    }

    public static UserInfoDto of(User user) {
        return UserInfoDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .birth(user.getBirth())
                .gender(user.getGender())
                .build();
    }

    // == 정보 수정 == //

    // 회원 비밀번호 수정
    public void updatePassword(String password) {
        this.password = password;
    }

    // 회원정보 수정
    public void update(String identity,
                       String email,
                       String phone,
                       String address,
                       String gender) {
        this.identity = identity;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }
}
