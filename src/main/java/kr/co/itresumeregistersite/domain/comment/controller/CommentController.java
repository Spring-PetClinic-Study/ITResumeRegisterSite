package kr.co.itresumeregistersite.domain.comment.controller;

import kr.co.itresumeregistersite.domain.comment.dto.RegisterCommentDto;
import kr.co.itresumeregistersite.domain.comment.service.CommentService;
import kr.co.itresumeregistersite.global.error.response.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // TODO : 댓글 등록
    @PostMapping()
    public ResponseFormat registerComment(RegisterCommentDto registerCommentDto) {
        commentService.registerComment(registerCommentDto);
        return ResponseFormat.ok();
    }

    // TODO : 댓글 조회

    // TODO : 댓글 수정

    // TODO : 댓글 삭제
}
