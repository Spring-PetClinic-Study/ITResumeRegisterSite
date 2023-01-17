package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.boardDto.BoardInfoDto;
import kr.co.itresumeregistersite.domain.dto.boardDto.PostSaveDto;
import kr.co.itresumeregistersite.domain.entity.Board;
import kr.co.itresumeregistersite.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 전체 목록 조회
    @GetMapping
    public List<Board> findAllboardInfo() {
        return boardService.findAllboardInfo();
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
