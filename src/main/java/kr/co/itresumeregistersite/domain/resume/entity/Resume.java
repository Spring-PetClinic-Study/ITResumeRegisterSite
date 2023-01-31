package kr.co.itresumeregistersite.domain.resume.entity;

import kr.co.itresumeregistersite.domain.resume.dto.RegisterResumeDto;
import kr.co.itresumeregistersite.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "company_name", length = 30, nullable = false)
    private String companyName; // 지원 회사명

    @Column(length = 30)
    private String major;   // 전공

    @Column(length = 30)
    private String minor;   // 부전공

    @Column(length = 125, nullable = false)
    private String profile; // 자기소개서

    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;   // foreign Key


    public static Resume of(RegisterResumeDto registerResumeDto) {
        return Resume.builder()
                .schoolName(registerResumeDto.getSchoolName())
                .companyName(registerResumeDto.getCompanyName())
                .major(registerResumeDto.getMajor())
                .minor(registerResumeDto.getMinor())
                .profile(registerResumeDto.getProfile())
                .registerDate(LocalDateTime.now())
                .build();
    }
}
