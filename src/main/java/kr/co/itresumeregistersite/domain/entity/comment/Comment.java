package kr.co.itresumeregistersite.domain.entity.comment;

import kr.co.itresumeregistersite.domain.entity.board.Board;
import kr.co.itresumeregistersite.domain.entity.user.User;
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
    private Long commentId;

    private String comment;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name ="modifie_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board boardId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
}
