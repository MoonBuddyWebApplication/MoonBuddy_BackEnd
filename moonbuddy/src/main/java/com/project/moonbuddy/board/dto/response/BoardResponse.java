package com.project.moonbuddy.board.dto.response;

import com.project.moonbuddy.board.Reply;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class BoardResponse {
    private String title;
    private String writer;
    private String content;
    private int likes;
    private String createdDate;
    private List<Reply> replyList;
}
