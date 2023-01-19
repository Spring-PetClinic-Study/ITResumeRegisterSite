package kr.co.itresumeregistersite.domain.entity;

import kr.co.itresumeregistersite.domain.dto.usersDto.SignUpDto;
import kr.co.itresumeregistersite.domain.dto.usersDto.UsersInfoDto;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
@Table(name = "tbl_users")
public class Users {

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

    public static Users of(SignUpDto signUpDto){
        return Users.builder()
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

    public static UsersInfoDto of(Users users){
        return UsersInfoDto.builder()
                .name(users.getName())
                .email(users.getEmail())
                .birth(users.getBirth())
                .gender(users.getGender())
                .build();
    }

    // == 정보 수정 == //

    // 회원 비밀번호 수정
    public void updatePassword(String password) {
        this.password = password;
    }

    // 회원정보 수정
    public void update(String email,
                       String phone,
                       String address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
