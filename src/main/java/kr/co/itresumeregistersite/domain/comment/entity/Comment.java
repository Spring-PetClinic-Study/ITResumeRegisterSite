package kr.co.itresumeregistersite.domain.comment.entity;

import kr.co.itresumeregistersite.domain.board.entity.Board;
import kr.co.itresumeregistersite.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_comment")
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId; // primary key

    private String writer;  // 작성자

    private String comment; // 댓글

    @Column(name = "registed_date")
    private LocalDateTime registedDate;  // 댓글 작성 날짜

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board boardId;  // foreign key
}
