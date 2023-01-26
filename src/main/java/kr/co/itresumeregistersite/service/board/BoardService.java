package kr.co.itresumeregistersite.service.board;

import kr.co.itresumeregistersite.domain.entity.board.dto.EditPostDto;
import kr.co.itresumeregistersite.domain.entity.board.dto.SavePostDto;
import kr.co.itresumeregistersite.domain.entity.board.Board;
import kr.co.itresumeregistersite.domain.exception.NoSuchDataException;
import kr.co.itresumeregistersite.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    /* TODO
        1. Exception
        2. Response Format API
        3. test
        4. comment
     */

    private final BoardRepository boardRepository;

    // 게시글 작성
    @Transactional
    public void postSave(SavePostDto savePostDto) {

        // 제목, 작성자, 내용 미입력 시 예외 발생
        NoInputTitle(savePostDto.getTitle());
        NoInputWriter(savePostDto.getWriter());
        NoInputContent(savePostDto.getContent());

        final Board board = Board.of(savePostDto);
        boardRepository.save(board);
    }

    // 게시글 전체 목록 조회
    @Transactional(readOnly = true)
    public Page<Board> findAllPostInfo(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    // 특정 게시글 조회
    @Transactional(readOnly = true)
    public List<Board> search(String title, Pageable pageable) {
        List<Board> boardList = boardRepository.findByTitle(title, pageable);

        return boardList;
    }

    // 게시글 수정
    @Transactional
    public void editPost(EditPostDto editPostDto) {
        Board board = boardRepository.findById(editPostDto.getBoardId())
                        .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_POST));

        // 제목, 내용이 비어있을 경우 예외 발생
        NoInputTitle(editPostDto.getTitle());
        NoInputContent(editPostDto.getContent());

        board.edit(editPostDto.getTitle(), editPostDto.getContent());
    }

    // 게시글 삭제
    @Transactional
    public void deletePost(Long boardId) {
        boardRepository.deleteById(boardId);
    }


    // 제목 작성 여부 검사
    public void NoInputTitle(String title) {
        if (title.isEmpty()) {
            throw new NoSuchDataException(NoSuchDataExceptionType.TITLE_NOT_EXIST);
        }
    }

    // 작성자 작성 여부 검사
    public void NoInputWriter(String writer) {
        if (writer.isEmpty()) {
            throw new NoSuchDataException(NoSuchDataExceptionType.WRITER_NOT_EXIST);
        }
    }

    // 내용 작성 여부 검사
    public void NoInputContent(String content) {
        if (content.isEmpty()) {
            throw new NoSuchDataException(NoSuchDataExceptionType.CONTENT_NOT_EXIST);
        }
    }
}
