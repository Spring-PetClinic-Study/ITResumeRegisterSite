package kr.co.itresumeregistersite.repository;

import kr.co.itresumeregistersite.domain.entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitle(String title, Pageable pageable);
}
