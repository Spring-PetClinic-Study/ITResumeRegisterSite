package kr.co.itresumeregistersite.domain.entity;

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

    @Id @GeneratedValue
    @Column(name = "career_id")
    private Long careerId;

    @OneToOne
    @JoinColumn(name = "Resume_Id", referencedColumnName = "ID")
    private Resume resumeId;

    @Column(length = 20, nullable = false)
    private String companyName;

    @Column(length = 20, nullable = false)
    private String department;

    @Column(name = "employment_year")
    private LocalDateTime employmentYear;

    @Column(name = "resignation_year")
    private LocalDateTime resignationYear;

    @Column(length = 20, nullable = false)
    private String position;

    @Column(length = 20, nullable = false)
    private String responsibility;
}
