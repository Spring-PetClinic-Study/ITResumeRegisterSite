package kr.co.itresumeregistersite.domain.board.service;

import kr.co.itresumeregistersite.domain.board.dto.EditPostDto;
import kr.co.itresumeregistersite.domain.board.dto.PostInfoDto;
import kr.co.itresumeregistersite.domain.board.dto.SavePostDto;
import kr.co.itresumeregistersite.domain.board.entity.Board;
import kr.co.itresumeregistersite.global.error.exception.board.NotExistContentException;
import kr.co.itresumeregistersite.global.error.exception.board.NotExistTitleException;
import kr.co.itresumeregistersite.global.error.exception.board.NotExistWriterException;
import kr.co.itresumeregistersite.domain.board.repository.BoardRepository;
import kr.co.itresumeregistersite.global.error.exception.board.NotFoundPostException;
import lombok.RequiredArgsConstructor;
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
        noCorrespondingPostTitle(savePostDto.getTitle());
        noCorrespondingPostWriter(savePostDto.getWriter());
        noCorrespondingPostContent(savePostDto.getContent());

        final Board board = Board.of(savePostDto);

        boardRepository.save(board);
    }

    // 게시글 전체 목록 조회
    @Transactional(readOnly = true)
    public List<PostInfoDto> findAllPostInfo() {
        return boardRepository.findPostListBy();
    }

    // 특정 게시글 조회
    @Transactional(readOnly = true)
    public List<Board> search(String title) {
        noSuchPost(title);

        List<Board> boardList = boardRepository.findByTitle(title);
        return boardList;
    }

    // 게시글 수정
    @Transactional
    public void editPost(EditPostDto editPostDto) {
        Board board = boardRepository.findByBoardId(editPostDto.getBoardId())
                .orElseThrow(NotFoundPostException::new);

        // 제목, 내용이 비어있을 경우 예외 발생
        noCorrespondingPostTitle(editPostDto.getTitle());
        noCorrespondingPostContent(editPostDto.getContent());

        board.edit(editPostDto.getTitle(), editPostDto.getContent());
    }

    // 게시글 삭제
    @Transactional
    public void deletePost(Long boardId) {
        boardRepository.findByBoardId(boardId)
                .orElseThrow(NotFoundPostException::new);

        boardRepository.deleteByBoardId(boardId);
    }



    // 제목 작성 여부 검사
    private void noCorrespondingPostTitle(String title) {
        if (title.isEmpty()) {
            throw new NotExistTitleException();
        }
    }

    // 작성자 작성 여부 검사
    private void noCorrespondingPostWriter(String writer) {
        if (writer.isEmpty()) {
            throw new NotExistWriterException();
        }
    }

    // 내용 작성 여부 검사
    private void  noCorrespondingPostContent(String content) {
        if (content.isEmpty()) {
            throw new NotExistContentException();
        }
    }

    // 작성된 게시글이 없을 경우 검사
    private void noSuchPost(String title) {
        List<Board> boardList = boardRepository.findByTitle(title);
        if (boardList.isEmpty()) {
            throw new NotFoundPostException();
        }
    }
}
