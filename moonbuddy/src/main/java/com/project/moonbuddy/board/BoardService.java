package com.project.moonbuddy.board;

import com.project.moonbuddy.board.dto.request.BoardWrite;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BoardService {

    private BoardRepository boardRepository;

    public String register(BoardWrite boardWrite) {
        Board board = Board.builder()
                .title(boardWrite.getTitle())
                .content(boardWrite.getContent())
                .userSn(1L)
                .userName("김채원")
                .build();
        boardRepository.save(board);
        return "SUCCESS";
    }

    public String delete(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 글입니다."));
        boardRepository.delete(board);
        return "SUCCESS";
    }

    public String update(Long id, BoardWrite boardWrite) {

        Board new_board = Board.builder()
                .id(id)
                .title(boardWrite.getTitle())
                .content(boardWrite.getContent())
                .build();
        boardRepository.save(new_board);
        return "SUCCESS";
    }

    public BoardResponse select(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("존재하지 않는 글입니다."));

        BoardResponse boardResponse = BoardResponse.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .userName(board.getUserName())
                .build();
        return boardResponse;
    }

    public List<BoardResponse> selectAll() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardResponse> result = new ArrayList<>();
        boardList.forEach(v->{
            result.add(BoardResponse.builder()
                            .title(v.getTitle())
                            .content(v.getContent())
                            .userName(v.getUserName())
                    .build());
        });
        return result;
    }
}
