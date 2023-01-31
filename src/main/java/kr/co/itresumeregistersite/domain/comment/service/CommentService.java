package kr.co.itresumeregistersite.domain.comment.service;

import kr.co.itresumeregistersite.domain.comment.dto.CommentDto;
import kr.co.itresumeregistersite.domain.comment.entity.Comment;
import kr.co.itresumeregistersite.domain.comment.repository.CommentRepository;
import kr.co.itresumeregistersite.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    // 댓글 등록
    public void registerComment(CommentDto commentDto) {
        Comment comment = Comment.of(commentDto);

        commentRepository.save(comment);
    }

    // 댓글 조회
    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    // TODO : 댓글 수정

    // TODO : 댓글 삭제
}
