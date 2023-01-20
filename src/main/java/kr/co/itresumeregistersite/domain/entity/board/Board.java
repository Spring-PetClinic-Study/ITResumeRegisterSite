package kr.co.itresumeregistersite.domain.entity.board;

import kr.co.itresumeregistersite.domain.entity.board.dto.PostSaveDto;
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

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long boardId;   // primary Key

    @Column(length = 20, nullable = false)
    private String title;   // 제목

    @Column(length = 125, nullable = false)
    private String content; // 내용

    @Column(length = 20, nullable = false)
    private String writer;  // 작성자

    // TODO BaseTimeEntity에 대해서 공부
    @Column(name = "created_date")
    private LocalDateTime createdDate;  // 생성일

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate; // 수정일

    public static Board of(PostSaveDto postSaveDto) {
        return Board.builder()
                .title(postSaveDto.getTitle())
                .content(postSaveDto.getContent())
                .writer(postSaveDto.getWriter())
                .createdDate(LocalDateTime.now())
                .build();
    }


    public void edit(String title,
                     String content) {
        this.title = title;
        this.content = content;
    }
}

