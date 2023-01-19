package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.boardsDto.DeletePostDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.EditPostDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.PostInfoDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.PostSaveDto;
import kr.co.itresumeregistersite.domain.entity.Board;
import kr.co.itresumeregistersite.domain.exception.NoSuchDataException;
import kr.co.itresumeregistersite.domain.exception.NoSuchDataExceptionType;
import kr.co.itresumeregistersite.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    /* TODO 게시판 ⭕️❌
        1. 게시글 작성
            - I. title, writer, content 작성 ⭕
            - II. createdDate 할당 ❌
            - III. title, writer, content 미입력 시 예외 발생 ⭕
        2. 게시글 전체 조회
            - I. 모든 게시글 조회
            - II. 각 게시글은 title, writer, createdDate / modifiedDate를 표시
            - III. 각 게시글은 한 페이지에 10개씩 조회
            - IV. 페이지로 구분
        3. 특정 게시글 조회
            - I. 해당 제목과 동일한 이름으로 검색할 경우 모든 게시글 조회
        4. 게시글 수정
            - I. 게시글 title 수정
            - II. 게시글 content 수정
            - III. title, content가 null일 경우 예외 발생
        5. 게시글 삭제
            - I. 각 게시글의 boardId로 삭제
            - II. 모든 title, writer, content 삭제
     */

    private final BoardRepository boardRepository;

    // 게시글 작성
    @Transactional
    public void postSave(PostSaveDto postSaveDto) {

        // 제목, 작성자, 내용 미입력 시 예외 발생
        NoInputTitle(postSaveDto.getTitle());
        NoInputWriter(postSaveDto.getWriter());
        NoInputContent(postSaveDto.getContent());

        final Board board = Board.of(postSaveDto);
        boardRepository.save(board);
    }

    // 게시글 전체 목록 조회
    @Transactional(readOnly = true)
    public List<Board> findAllBoardInfo() {
        return boardRepository.findAll();
    }

    // 특정 게시글 조회
    @Transactional(readOnly = true)
    public PostInfoDto findBoardInfo(Long boardId) {
        Board board = boardRepository.findByBoardId(boardId);

        return Board.of(board);
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
    public void deletePost(DeletePostDto deletePostDto) {
        // 작성된 게시글이 없을 경우 예외 발생
        Board board = boardRepository.findById(deletePostDto.getBoardId())
                        .orElseThrow(() -> new NoSuchDataException(NoSuchDataExceptionType.NOT_FOUND_POST));

        boardRepository.delete(board);
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
