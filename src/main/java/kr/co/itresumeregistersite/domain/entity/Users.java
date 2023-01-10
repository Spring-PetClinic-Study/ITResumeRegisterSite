package kr.co.itresumeregistersite.domain.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
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

    public Users() {}

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
