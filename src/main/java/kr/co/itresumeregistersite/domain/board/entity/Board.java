package kr.co.itresumeregistersite.domain.board.entity;

import kr.co.itresumeregistersite.domain.board.dto.SavePostDto;
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

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long boardId;   // primary key

    @Column(length = 125, nullable = false)
    private String title;   // 제목

    @Column(length = 125, nullable = false)
    private String content; // 내용

    @Column(length = 20, nullable = false)
    private String writer;  // 작성자

    @Column(name = "created_date")
    private LocalDateTime createdDate;  // 생성일

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate; // 수정일

//    @OneToMany(cascade = CascadeType.REMOVE)    // 게시글이 삭제될 경우 댓글도 같이 삭제하기 위함(cascade)
//    private List<Comment> comments;

    public static Board of(SavePostDto savePostDto) {
        return Board.builder()
                .title(savePostDto.getTitle())
                .content(savePostDto.getContent())
                .writer(savePostDto.getWriter())
                .createdDate(LocalDateTime.now())
                .build();
    }


    public void edit(String title,
                     String content) {
        this.title = title;
        this.content = content;
    }
}

