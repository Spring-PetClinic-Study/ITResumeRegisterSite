package kr.co.itresumeregistersite.domain.comment.controller;

import kr.co.itresumeregistersite.domain.comment.dto.EditCommentDto;
import kr.co.itresumeregistersite.domain.comment.dto.RegisterCommentDto;
import kr.co.itresumeregistersite.domain.comment.entity.Comment;
import kr.co.itresumeregistersite.domain.comment.service.CommentService;
import kr.co.itresumeregistersite.global.error.response.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping()
    public ResponseFormat registerComment(@RequestBody RegisterCommentDto registerCommentDto) {
        commentService.registerComment(registerCommentDto);
        return ResponseFormat.ok();
    }

    // 댓글 조회
    @GetMapping()
    public ResponseFormat<List<Comment>> findAllComment() {
        return ResponseFormat.ok(commentService.findAllComment());
    }

    // 댓글 수정
    @PutMapping()
    public ResponseFormat editComment(@RequestBody EditCommentDto editCommentDto) {
        commentService.editComment(editCommentDto);
        return ResponseFormat.ok();
    }

    // 댓글 삭제
    @DeleteMapping()
    public ResponseFormat deleteComment(@RequestParam Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseFormat.ok();
    }
}
