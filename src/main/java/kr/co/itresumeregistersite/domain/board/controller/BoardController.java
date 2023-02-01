package kr.co.itresumeregistersite.domain.board.controller;

import kr.co.itresumeregistersite.domain.board.dto.EditPostDto;
import kr.co.itresumeregistersite.domain.board.dto.PostInfoDto;
import kr.co.itresumeregistersite.domain.board.dto.SavePostDto;
import kr.co.itresumeregistersite.domain.board.entity.Board;
import kr.co.itresumeregistersite.domain.board.service.BoardService;
import kr.co.itresumeregistersite.global.error.response.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 등록
    @PostMapping
    public ResponseFormat savePost(@RequestBody @Valid SavePostDto savePostDto) {
        boardService.savePost(savePostDto);
        return ResponseFormat.ok();
    }

    // 게시글 전체 목록 조회
    @GetMapping("/findAll")
    public ResponseFormat<List<PostInfoDto>> findAllPostInfo() {
        return ResponseFormat.ok(boardService.findAllPostInfo());
    }

    // 특정 게시글 조회
    @GetMapping
    public ResponseFormat<List<Board>> search(@RequestParam("title") String title) {
        return ResponseFormat.ok(boardService.search(title));
    }

    // 게시글 수정
    @PutMapping
    public ResponseFormat editPost(@RequestBody @Valid EditPostDto editPostDto) {
        boardService.editPost(editPostDto);
        return ResponseFormat.ok();
    }

    // 게시글 삭제
    @DeleteMapping
    public ResponseFormat deletePost(@RequestParam("boardId") @Valid Long boardId) {
        boardService.deletePost(boardId);
        return ResponseFormat.ok();
    }

}
