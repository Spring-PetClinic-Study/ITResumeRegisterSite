package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.boardDto.BoardDto;
import kr.co.itresumeregistersite.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor    //TODO 공부
public class BoardController {

    //주입 방법이 총 3가지 있는데, 공부를 해야할 것 같음. 보통 생성자 주입 많이 쓰는데 왜 쓰는지도~
    private final BoardService boardService;

//    public BoardController(BoardService boardService) {
//        this.boardService = boardService;
//    }

    // TODO 게시글 작성 -> HTTP Method 공부
    @PostMapping
    public void writePost(BoardDto boardDto) {
        boardService.savePost(boardDto);
    }

}
