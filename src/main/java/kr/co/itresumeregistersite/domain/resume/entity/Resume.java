package kr.co.itresumeregistersite.domain.resume.entity;

import kr.co.itresumeregistersite.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "tbl_resume")
public class Resume {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long resumeId;  // primary Key

    @Column(name = "school_name", length = 30, nullable = false)
    private String schoolName;  // 학교명

    @Column(length = 30, nullable = false)
    private String major;   // 전공

    @Column(length = 30, nullable = false)
    private String minor;   // 부전공

    @Column(length = 125, nullable = false)
    private String profile; // 자기소개서

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;   // foreign Key
}
