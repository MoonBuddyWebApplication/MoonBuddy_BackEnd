package com.project.moonbuddy.board;

import com.project.moonbuddy.board.dto.request.BoardWrite;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BoardService {

    private BoardRepository boardRepository;
    public String register(BoardWrite boardWrite) {
        Board board = Board.builder()
                .title(boardWrite.getTitle())
                .content(boardWrite.getContent())
                .userSn(1L)
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
                .userSn(1L)
                .build();
        boardRepository.save(new_board);
        return "SUCCESS";
    }

    public Board select(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("존재하지 않는 글입니다."));
        return board;
    }
}
