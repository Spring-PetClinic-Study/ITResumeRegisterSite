package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.boardsDto.DeletePostDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.EditPostDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.PostInfoDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.PostSaveDto;
import kr.co.itresumeregistersite.domain.entity.Board;
import kr.co.itresumeregistersite.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 전체 목록 조회
    @GetMapping
    public List<Board> findAllBoardInfo() {
        return boardService.findAllBoardInfo();
    }

    // 특정 게시글 조회
    @GetMapping("/title")
    public PostInfoDto findBoardInfo(Long boardId) {
        return boardService.findBoardInfo(boardId);
    }

    // 게시글 등록
    @PostMapping
    public void postSave(PostSaveDto postSaveDto) {
        boardService.postSave(postSaveDto);
    }

    // 게시글 수정
    @PutMapping
    public void editPost(EditPostDto editPostDto) {
        boardService.editPost(editPostDto);
    }

    // 게시글 삭제
    @DeleteMapping
    public void deletePost(DeletePostDto deletePostDto) {
        boardService.deletePost(deletePostDto);
    }

}
