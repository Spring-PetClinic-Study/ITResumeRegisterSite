package kr.co.itresumeregistersite.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tbl_board")
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long boardId;   // primary Key

    @Column(length = 20, nullable = false)
    private String title;   // 제목

    @Column(length = 125, nullable = false)
    private String content; // 내용

    @Column(length = 20, nullable = false)
    private String writer;  // 작성자

    @Column(name = "created_date")
    private LocalDateTime createdDate;  // 생성일

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate; // 수정일
}

