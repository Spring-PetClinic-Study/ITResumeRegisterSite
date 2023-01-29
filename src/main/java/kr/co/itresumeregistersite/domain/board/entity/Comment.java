package kr.co.itresumeregistersite.domain.board.entity;

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

    private String comment; // 댓글

    @Column(name = "create_date")
    private LocalDateTime createdDate;  // 생성일

    @Column(name ="modifie_date")
    private LocalDateTime modifiedDate; // 수정일

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board boardId;  // foreign key

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;    // 작성자
}
