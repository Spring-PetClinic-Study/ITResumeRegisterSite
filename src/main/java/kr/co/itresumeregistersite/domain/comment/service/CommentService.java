package kr.co.itresumeregistersite.domain.comment.service;

import kr.co.itresumeregistersite.domain.comment.dto.RegisterCommentDto;
import kr.co.itresumeregistersite.domain.comment.entity.Comment;
import kr.co.itresumeregistersite.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    // 댓글 등록
    public void registerComment(RegisterCommentDto registerCommentDto) {
        Comment comment = Comment.of(registerCommentDto);

        commentRepository.save(comment);
    }

    // TODO : 댓글 조회

    // TODO : 댓글 수정

    // TODO : 댓글 삭제
}
