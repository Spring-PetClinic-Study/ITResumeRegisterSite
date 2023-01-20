package kr.co.itresumeregistersite.domain.entity.resume;

import kr.co.itresumeregistersite.domain.entity.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tbl_resume")
public class Resume {

    @Id @GeneratedValue
    @Column(name = "resume_id")
    private Long resumeId;  // primary Key

    @ManyToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "ID")
    private User userId;   // foreign Key

    @Column(name = "school_name", length = 30, nullable = false)
    private String schoolName;  // 학교명

    @Column(length = 30, nullable = false)
    private String major;   // 전공

    @Column(length = 30, nullable = false)
    private String minor;   // 부전공

    @Column(length = 125, nullable = false)
    private String profile; // 자기소개서
}
