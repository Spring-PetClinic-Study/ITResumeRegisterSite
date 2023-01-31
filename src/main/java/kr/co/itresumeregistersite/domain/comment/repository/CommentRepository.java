package kr.co.itresumeregistersite.domain.comment.repository;

import kr.co.itresumeregistersite.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findByCommentId(Long commentId);
}
