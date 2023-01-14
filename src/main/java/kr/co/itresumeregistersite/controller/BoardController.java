package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.boardDto.BoardInfoDto;
import kr.co.itresumeregistersite.domain.dto.boardDto.PostSaveDto;
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

    // TODO 게시글 목록
    public BoardInfoDto boardInfo(Long boardId) {
        return boardService.boardInfo(boardId);
    }

    // TODO 게시글 상세조회

    // 게시글 등록
    @PostMapping
    public void postSave(PostSaveDto postSaveDto) {
        boardService.postSave(postSaveDto);
    }

    // TODO 게시글 수정

    // TODO 게시글 삭제

}
