package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.boardDto.BoardInfoDto;
import kr.co.itresumeregistersite.domain.dto.boardDto.PostSaveDto;
import kr.co.itresumeregistersite.domain.entity.Board;
import kr.co.itresumeregistersite.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 전체 목록 조회
    @Transactional(readOnly = true)
    public List<Board> findAllboardInfo() {
        return boardRepository.findAll();
    }

    // 게시글 작성
    @Transactional
    public void postSave(PostSaveDto postSaveDto) {

        // TODO 제목, 작성자, 내용 미입력 시 예외 발생
        final Board board = Board.of(postSaveDto);
        boardRepository.save(board);
    }
}
