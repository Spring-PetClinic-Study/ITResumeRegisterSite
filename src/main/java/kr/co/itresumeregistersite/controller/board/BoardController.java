package kr.co.itresumeregistersite.controller.board;

import kr.co.itresumeregistersite.domain.entity.board.dto.EditPostDto;
import kr.co.itresumeregistersite.domain.entity.board.dto.SavePostDto;
import kr.co.itresumeregistersite.domain.entity.board.Board;
import kr.co.itresumeregistersite.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public void postSave(@RequestBody @Valid SavePostDto savePostDto) {
        boardService.postSave(savePostDto);
    }

    // 게시글 전체 목록 조회
    @GetMapping("/findAll")
    public Page<Board> findAllPostInfo(@PageableDefault(size = 10, sort = "board_id",
            direction = Sort.Direction.DESC) Pageable pageable) {
        return boardService.findAllPostInfo(pageable);
    }

    // 특정 게시글 조회
    @GetMapping
    public List<Board> search(@RequestParam String title, Pageable pageable) {
        return boardService.search(title, pageable);
    }

    // 게시글 수정
    @PutMapping
    public void editPost(@RequestBody @Valid EditPostDto editPostDto) {
        boardService.editPost(editPostDto);
    }

    // 게시글 삭제
    @DeleteMapping
    public void deletePost(@RequestBody @Valid Long boardId) {
        boardService.deletePost(boardId);
    }

}
