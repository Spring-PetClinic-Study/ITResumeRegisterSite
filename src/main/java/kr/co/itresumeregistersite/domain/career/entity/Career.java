package kr.co.itresumeregistersite.domain.career.entity;

import kr.co.itresumeregistersite.domain.resume.entity.Resume;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tbl_career")
public class Career {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id")
    private Long careerId;  // primary Key

    @Column(length = 20, nullable = false)
    private String companyName; // 회사명

    @Column(length = 20, nullable = false)
    private String department;  // 부서

    @Column(name = "employment_year")
    private LocalDateTime employmentYear;   // 입사년도

    @Column(name = "resignation_year")
    private LocalDateTime resignationYear;  // 퇴사년도

    @Column(length = 20, nullable = false)
    private String position;    // 직책

    @Column(name = "assigned_task", length = 20, nullable = false)
    private String assignedTask;  // 담당업무

    @OneToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;    // foreign Key
}
