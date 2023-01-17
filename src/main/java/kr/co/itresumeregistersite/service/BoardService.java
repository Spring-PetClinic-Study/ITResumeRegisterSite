package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.boardDto.EditPostDto;
import kr.co.itresumeregistersite.domain.dto.boardDto.PostSaveDto;
import kr.co.itresumeregistersite.domain.entity.Board;
import kr.co.itresumeregistersite.domain.entity.Users;
import kr.co.itresumeregistersite.repository.BoardRepository;
import kr.co.itresumeregistersite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UsersRepository usersRepository;

    // 게시글 전체 목록 조회
    @Transactional(readOnly = true)
    public List<Board> findAllBoardInfo() {
        return boardRepository.findAll();
    }

    // 게시글 작성
    @Transactional
    public void postSave(PostSaveDto postSaveDto) {

        // TODO 제목, 작성자, 내용 미입력 시 예외 발생
        final Board board = Board.of(postSaveDto);
        boardRepository.save(board);
    }

    // 게시글 수정
    @Transactional
    public void editPost(EditPostDto editPostDto) {
        // TODO 비밀번호를 입력받고 틀릴 경우 예외 발생
        Optional<Board> board = boardRepository.findById(editPostDto.getBoardId());

        board.get().edit(editPostDto.getTitle(), editPostDto.getContent());
    }
}
