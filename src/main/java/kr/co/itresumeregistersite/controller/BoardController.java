package kr.co.itresumeregistersite.controller;

import kr.co.itresumeregistersite.domain.dto.boardsDto.DeletePostDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.EditPostDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.PostInfoDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.PostSaveDto;
import kr.co.itresumeregistersite.domain.entity.Board;
import kr.co.itresumeregistersite.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 등록
    @PostMapping
    public void postSave(@RequestBody PostSaveDto postSaveDto) {
        boardService.postSave(postSaveDto);
    }

    // 게시글 전체 목록 조회
    @GetMapping("/findAll")
    public Page<Board> findAllPostInfo(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)
                                           Pageable pageable) {
        return boardService.findAllPostInfo(pageable);
    }

    // 특정 게시글 조회
    @GetMapping
    public List<Board> search(@RequestParam String title) {
        List<Board> searchList = boardService.search(title);

        return searchList;
    }

    // 게시글 수정
    @PutMapping
    public void editPost(@RequestBody EditPostDto editPostDto) {
        boardService.editPost(editPostDto);
    }

    // 게시글 삭제
    @DeleteMapping
    public void deletePost(@RequestBody Long boardId) {
        boardService.deletePost(boardId);
    }

}
