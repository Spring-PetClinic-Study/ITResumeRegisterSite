package kr.co.itresumeregistersite.domain.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
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
    public Users() {}

    // 회원 수정 메소드
    public void update() {}
}
