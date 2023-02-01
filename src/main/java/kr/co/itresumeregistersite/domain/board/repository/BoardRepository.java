package kr.co.itresumeregistersite.domain.board.repository;

import kr.co.itresumeregistersite.domain.board.dto.PostInfoDto;
import kr.co.itresumeregistersite.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByBoardId(Long boardId);

    Optional<Board> deleteByBoardId(Long boardId);

    List<Board> findByTitle(String title);

    List<PostInfoDto> findPostListBy();
}
