package com.project.moonbuddy.board;

import com.project.moonbuddy.board.dto.request.BoardWrite;
import com.project.moonbuddy.user.User;
import com.project.moonbuddy.user.UserService;
import com.project.moonbuddy.user.config.oauth.dto.SessionUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    private final UserService userService;
    private HttpSession httpSession;

    @Autowired
    public BoardController(BoardService boardService, UserService userService) {
        this.boardService = boardService;
        this.userService = userService;
    }

    @GetMapping("/viewAll")
    public ResponseEntity viewAll(){
        List<BoardResponse> boardList = boardService.selectAll();
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @PostMapping("/post")
    public ResponseEntity post(@RequestBody BoardWrite boardWrite){
        //SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        //User user = userService.findUser(sessionUser);
        log.info("boardWrite={}", boardWrite);
        String status = boardService.register(boardWrite);

        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        String status = boardService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody BoardWrite boardWrite){
        String status = boardService.update(id, boardWrite);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }


    @GetMapping("/view/{id}")
    public ResponseEntity view(@PathVariable("id") Long id){
        BoardResponse boardResponse = boardService.select(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponse);
    }

}
