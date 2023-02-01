package kr.co.itresumeregistersite.domain.resume.entity;

import kr.co.itresumeregistersite.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tbl_resume")
public class Resume {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long resumeId;  // primary Key

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;   // foreign Key

    @Column(name = "school_name", length = 30, nullable = false)
    private String schoolName;  // 학교명

    @Column(length = 30, nullable = false)
    private String major;   // 전공

    @Column(length = 30, nullable = false)
    private String minor;   // 부전공

    @Column(length = 125, nullable = false)
    private String profile; // 자기소개서

    @Builder
    public Resume(User userId,
                  String schoolName,
                  String major,
                  String minor,
                  String profile) {
        this.userId = userId;
        this.schoolName = schoolName;
        this.major = major;
        this.minor = minor;
        this.profile = profile;
    }
}
