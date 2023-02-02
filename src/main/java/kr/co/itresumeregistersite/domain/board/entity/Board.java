package kr.co.itresumeregistersite.domain.board.entity;

import kr.co.itresumeregistersite.domain.board.dto.SavePostDto;
import kr.co.itresumeregistersite.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "tbl_board")
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;   // primary key

    @Column(length = 125, nullable = false)
    private String title;   // 제목

    @Column(length = 20, nullable = false)
    private String writer;  // 작성자

    @Column(length = 125, nullable = false)
    private String content; // 내용

    @Column(name = "created_date")
    private LocalDateTime createdDate;  // 생성일

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate; // 수정일

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Board of(SavePostDto savePostDto) {
        return Board.builder()
                .title(savePostDto.getTitle())
                .writer(savePostDto.getWriter())
                .content(savePostDto.getContent())
                .createdDate(LocalDateTime.now())
                .build();
    }


    public void edit(String title,
                     String content,
                     LocalDateTime modifiedDate) {
        this.title = title;
        this.content = content;
        this.modifiedDate = LocalDateTime.now();
    }
}

