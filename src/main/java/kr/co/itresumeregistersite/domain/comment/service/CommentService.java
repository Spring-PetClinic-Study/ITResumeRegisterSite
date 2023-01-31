package kr.co.itresumeregistersite.domain.comment.service;

import kr.co.itresumeregistersite.domain.comment.dto.CommentDto;
import kr.co.itresumeregistersite.domain.comment.entity.Comment;
import kr.co.itresumeregistersite.domain.comment.repository.CommentRepository;
import kr.co.itresumeregistersite.domain.user.repository.UserRepository;
import kr.co.itresumeregistersite.global.error.exception.board.NotExistWriterException;
import kr.co.itresumeregistersite.global.error.exception.comment.InvalidCommentException;
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
        // 댓글 작성자와 내용이 없을 경우 예외처리
        writerHasNotBeenEntered(commentDto.getWriter());
        noCommentHaveBeenWritten(commentDto.getComment());

        Comment comment = Comment.of(commentDto);
        commentRepository.save(comment);
    }

    // 댓글 조회
    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    // 댓글 수정
    public void editComment(CommentDto commentDto) {
        // 작성된 댓글들이 없을 경우 예외처리
        noCommentHaveBeenWritten(commentDto.getCommentId());
        Comment comment = commentRepository.findByCommentId(commentDto.getCommentId());

        // 댓글의 작성자, 댓글내용이 없을 경우 예외처리
        writerHasNotBeenEntered(comment.getWriter());
        noCommentHaveBeenWritten(comment.getComment());

        comment.edit(commentDto.getWriter(), commentDto.getComment());
        commentRepository.save(comment);
    }

    // 댓글 삭제
    public void deleteComment(Long commentId) {
        // 작성한 댓글이 없을 경우 예외처리
        noCommentHaveBeenWritten(commentId);
        commentRepository.deleteByCommentId(commentId);
    }



    // 댓글 작성자가 없을 경우 검사
    public void writerHasNotBeenEntered(String writer) {
       if (writer.isEmpty()) {
           throw new NotExistWriterException();
       }
    }

    // 댓글 내용이 없을 경우 검사
    public void noCommentHaveBeenWritten(String comment) {
        if (comment.isEmpty()) {
            throw new InvalidCommentException();
        }
    }

    // 작성된 댓글이 없을 경우 검사
    public void noCommentHaveBeenWritten(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new InvalidCommentException();
        }
    }
}
