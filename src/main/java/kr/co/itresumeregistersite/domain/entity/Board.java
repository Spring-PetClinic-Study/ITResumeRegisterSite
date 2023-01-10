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
    private Long boardId;
    @Column(length = 20, nullable = false)
    private String title;
    @Column(length = 125, nullable = false)
    private String content;
    @Column(length = 20, nullable = false)
    private String writer;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
}

