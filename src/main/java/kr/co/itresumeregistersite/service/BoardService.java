package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.boardDto.BoardDto;
import kr.co.itresumeregistersite.domain.entity.Board;
import kr.co.itresumeregistersite.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // TODO 게시글 작성
    @Transactional
    public void savePost(BoardDto boardDto) {

        final Board board = Board.of(boardDto);
        boardRepository.save(board);
    }
}
