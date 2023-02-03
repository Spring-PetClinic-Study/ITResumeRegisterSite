package kr.co.itresumeregistersite.domain.board.service;

import kr.co.itresumeregistersite.domain.board.dto.EditPostDto;
import kr.co.itresumeregistersite.domain.board.dto.PostInfoDto;
import kr.co.itresumeregistersite.domain.board.dto.SavePostDto;
import kr.co.itresumeregistersite.domain.board.entity.Board;
import kr.co.itresumeregistersite.global.error.exception.board.NotExistContentException;
import kr.co.itresumeregistersite.global.error.exception.board.NotExistTitleException;
import kr.co.itresumeregistersite.global.error.exception.board.NotExistWriterException;
import kr.co.itresumeregistersite.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 작성
    @Transactional
    public void savePost(SavePostDto savePostDto) {

        // 제목, 작성자, 내용 미입력 시 예외 발생
        noInputTitle(savePostDto.getTitle());
        noInputWriter(savePostDto.getWriter());
        noInputContent(savePostDto.getContent());

        final Board board = Board.of(savePostDto);
        boardRepository.save(board);
    }

    // 게시글 전체 목록 조회
    // test error
    @Transactional(readOnly = true)
    public List<PostInfoDto> findAllPostInfo() {
        return boardRepository.findPostListBy();
    }

    // 특정 게시글 조회
    @Transactional(readOnly = true)
    public List<Board> search(String title, Pageable pageable) {
        List<Board> boardList = boardRepository.findByTitle(title, pageable);

        return boardList;
    }

    // 게시글 수정
    // 게시글 수정 시 비밀번호를 입력받은 후 일치할 경우 수정할 수 있도록
    @Transactional
    public void editPost(EditPostDto editPostDto) {
        Optional<Board> board = boardRepository.findByBoardId(editPostDto.getBoardId());

        // 제목, 내용이 비어있을 경우 예외 발생
        noInputTitle(editPostDto.getTitle());
        noInputContent(editPostDto.getContent());

        board.get().edit(editPostDto.getTitle(), editPostDto.getContent());

        boardRepository.save(board.get());
    }

    // 게시글 삭제
    // 게시글 삭제 시 비밀번호를 입력받은 후 일치할 경우 삭제할 수 있도록
    @Transactional
    public void deletePost(Long boardId) {
        boardRepository.deleteById(boardId);
    }



    // 제목 작성 여부 검사
    public void noInputTitle(String title) {
        if (title.isEmpty()) {
            throw new NotExistTitleException();
        }
    }

    // 작성자 작성 여부 검사
    public void noInputWriter(String writer) {
        if (writer.isEmpty()) {
            throw new NotExistWriterException();
        }
    }

    // 내용 작성 여부 검사
    public void  noInputContent(String content) {
        if (content.isEmpty()) {
            throw new NotExistContentException();
        }
    }
}
