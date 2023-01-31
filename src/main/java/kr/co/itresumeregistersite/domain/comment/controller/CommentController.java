package kr.co.itresumeregistersite.domain.comment.controller;

import kr.co.itresumeregistersite.domain.comment.dto.CommentDto;
import kr.co.itresumeregistersite.domain.comment.entity.Comment;
import kr.co.itresumeregistersite.domain.comment.service.CommentService;
import kr.co.itresumeregistersite.global.error.response.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping()
    public ResponseFormat registerComment(CommentDto registerCommentDto) {
        commentService.registerComment(registerCommentDto);
        return ResponseFormat.ok();
    }

    // 댓글 조회
    @GetMapping()
    public List<Comment> findAllComment() {
        return commentService.findAllComment();
    }

    // TODO : 댓글 수정

    // TODO : 댓글 삭제
}
