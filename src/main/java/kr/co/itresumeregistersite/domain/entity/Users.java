package kr.co.itresumeregistersite.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tbl_user")
public class Users {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(length = 20, nullable = false)
    private String identity;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String birth;

    @Column(length = 30, nullable = false)
    private String address;

    @Column(length = 10, nullable = false)
    private String gender;

    @Builder
    public Users(Long userId,
                 String identity,
                 String password,
                 String name,
                 String phone,
                 String email,
                 String birth,
                 String address,
                 String gender) {
        this.userId = userId;
        this.identity = identity;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.address = address;
        this.gender = gender;
    }

    // 회원 수정 메소드
    public void update(String identity,
                       String name,
                       String phone,
                       String email,
                       String birth,
                       String address,
                       String gender) {
        this.identity = identity;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.address = address;
        this.gender = gender;
    }
}
