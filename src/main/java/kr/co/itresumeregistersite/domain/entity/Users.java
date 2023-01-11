package kr.co.itresumeregistersite.domain.entity;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    private Long usersId;

    @Column(length = 20, nullable = false, unique = true)
    private String identity;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String checkPassword;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false, unique = true)
    private String phone;

    @Column(length = 30, nullable = false, unique = true)
    private String email;

    @Column(length = 20, nullable = false)
    private String birth;

    @Column(length = 30, nullable = false)
    private String address;

    @Column(length = 10, nullable = false)
    private String gender;



    // == 정보 수정 == //

    // 회원 비밀번호 수정
    public void updatePassword(String password) {
        this.password = password;
    }

    // 회원정보 수정
    public void update(String email, String phone, String address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

//    비밀번호 변경, 회원탈퇴 시 비밀번호를 확인하며, 이때 비밀번호의 일치여부를 판단
//    public boolean matchPassword(PasswordEncoder passwordEncoder, String checkPassword) {
//        return passwordEncoder.matches(checkPassword, getPassword());
//    }
}
