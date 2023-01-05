package kr.co.itresumeregistersite.domain.entity;

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
    private Long resumeId;

    @ManyToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "ID")
    private Users userId;

    @Column(length = 30, nullable = false)
    private String school_name;

    @Column(length = 30, nullable = false)
    private String major;

    @Column(length = 30, nullable = false)
    private String minor;

    @Column(length = 125, nullable = false)
    private String profile;
}
