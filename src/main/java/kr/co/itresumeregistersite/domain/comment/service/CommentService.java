package kr.co.itresumeregistersite.domain.comment.service;

import kr.co.itresumeregistersite.domain.comment.dto.EditCommentDto;
import kr.co.itresumeregistersite.domain.comment.dto.RegisterCommentDto;
import kr.co.itresumeregistersite.domain.comment.entity.Comment;
import kr.co.itresumeregistersite.domain.comment.repository.CommentRepository;
import kr.co.itresumeregistersite.global.error.exception.board.NotExistWriterException;
import kr.co.itresumeregistersite.global.error.exception.comment.InvalidCommentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    // 댓글 등록
    @Transactional
    public void registerComment(RegisterCommentDto registerCommentDto) {
        // 댓글 작성자와 내용이 없을 경우 예외처리
        writerHasNotBeenEntered(registerCommentDto.getWriter());
        noCommentHaveBeenWritten(registerCommentDto.getComment());

        Comment comment = Comment.of(registerCommentDto);
        commentRepository.save(comment);
    }

    // 댓글 조회
    @Transactional(readOnly = true)
    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    // 댓글 수정
    @Transactional
    public void editComment(EditCommentDto editCommentDto) {
        // 작성된 댓글들이 없을 경우 예외처리
        noCommentHaveBeenWritten(editCommentDto.getCommentId());
        Optional<Comment> comment = commentRepository.findByCommentId(editCommentDto.getCommentId());

        // 댓글의 작성자, 댓글내용이 없을 경우 예외처리
        writerHasNotBeenEntered(comment.get().getWriter());
        noCommentHaveBeenWritten(comment.get().getComment());

        comment.get().edit(editCommentDto.getCommentId(),
                editCommentDto.getWriter(),
                editCommentDto.getComment(),
                editCommentDto.getModifiedDate());

        commentRepository.save(comment.get());
    }

    // 댓글 삭제
    @Transactional
    public void deleteComment(Long commentId) {
        // 작성한 댓글이 없을 경우 예외처리
        noCommentHaveBeenWritten(commentId);
        commentRepository.deleteById(commentId);
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
