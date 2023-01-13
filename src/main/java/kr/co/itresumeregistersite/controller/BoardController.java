package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.boardDto.BoardDto;
import kr.co.itresumeregistersite.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // TODO 게시글 목록 -> 제목, 글쓴이만 보이게

    // TODO 게시글 상세조회

    // 게시글 작성
    @PostMapping
    public void writePost(BoardDto boardDto) {
        boardService.savePost(boardDto);
    }

    // TODO 게시글 수정

    // TODO 게시글 삭제

}
