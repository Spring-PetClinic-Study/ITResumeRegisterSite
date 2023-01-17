package kr.co.itresumeregistersite.domain.entity;

import kr.co.itresumeregistersite.domain.dto.boardDto.PostInfoDto;
import kr.co.itresumeregistersite.domain.dto.boardDto.PostSaveDto;
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
                .modifiedDate(LocalDateTime.now())
                .build();
    }

    public static PostInfoDto of(Board board) {
        return PostInfoDto.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdDate(board.getCreatedDate())
                .modifiedDate(board.getModifiedDate())
                .build();
    }


    public void edit(String title,
                     String content) {
        this.title = title;
        this.content = content;
    }
}

