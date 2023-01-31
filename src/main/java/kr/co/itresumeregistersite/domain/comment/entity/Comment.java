package kr.co.itresumeregistersite.domain.comment.entity;

import kr.co.itresumeregistersite.domain.board.entity.Board;
import kr.co.itresumeregistersite.domain.comment.dto.EditCommentDto;
import kr.co.itresumeregistersite.domain.comment.dto.RegisterCommentDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "tbl_comment")
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId; // primary key

    private String writer;  // 작성자

    private String comment; // 댓글

    @Column(name = "register_date")
    private LocalDateTime registerDate;  // 댓글 작성 날짜

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate; // 댓글 수정 날짜

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;  // foreign key


    public static Comment of(RegisterCommentDto registerCommentDto) {
        return Comment.builder()
                .writer(registerCommentDto.getWriter())
                .comment(registerCommentDto.getComment())
                .registerDate(LocalDateTime.now())
                .build();
    }



    public void edit(String writer,
                     String comment) {
        this.writer = writer;
        this.comment = comment;
    }


}
