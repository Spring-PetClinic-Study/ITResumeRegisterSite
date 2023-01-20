package kr.co.itresumeregistersite.service;

import kr.co.itresumeregistersite.domain.dto.boardsDto.EditPostDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.PostInfoDto;
import kr.co.itresumeregistersite.domain.dto.boardsDto.PostSaveDto;
import kr.co.itresumeregistersite.domain.entity.Board;
import kr.co.itresumeregistersite.domain.exception.NoSuchDataException;
import kr.co.itresumeregistersite.domain.exception.NoSuchDataExceptionType;
import kr.co.itresumeregistersite.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    /* TODO 게시판
        1. 게시글 작성
            - I. title, writer, content 작성 ⭕
            - II. title, writer, content 미입력 시 예외 발생 ⭕
        2. 게시글 전체 조회
            - I. 모든 게시글 조회 ⭕
            - II. paging ❌
        3. 특정 게시글 조회
            - I. 해당 번호로 게시글 조회 ⭕
            - II. paging ❌
        4. 게시글 수정
            - I. 게시글 title 수정 ⭕
            - II. 게시글 content 수정 ⭕
            - III. title, content가 null일 경우 예외 발생 ⭕
        5. 게시글 삭제
            - I. 각 게시글을 boardId로 삭제 ⭕
     */

    /* TODO
        1. Exception
        2. Response Format API
        3. test
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
    public Page<Board> findAllPostInfo(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    // 특정 게시글 조회
    @Transactional(readOnly = true)
    public List<Board> search(String keyword) {
        List<Board> boardList = boardRepository.findByTitle(keyword);

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
