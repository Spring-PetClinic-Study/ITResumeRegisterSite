package kr.co.itresumeregistersite.domain.comment.controller;

import kr.co.itresumeregistersite.domain.comment.dto.CommentDto;
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
    public ResponseFormat registerComment(@RequestBody CommentDto registerCommentDto) {
        commentService.registerComment(registerCommentDto);
        return ResponseFormat.ok();
    }

    // 댓글 조회
    @GetMapping()
    public List<Comment> findAllComment() {
        return commentService.findAllComment();
    }

    // 댓글 수정
    @PostMapping()
    public ResponseFormat editComment(@RequestBody CommentDto commentDto) {
        commentService.editComment(commentDto);
        return ResponseFormat.ok();
    }


    // 댓글 삭제
    @DeleteMapping()
    public ResponseFormat deleteComment(@RequestParam Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseFormat.ok();
    }
}
