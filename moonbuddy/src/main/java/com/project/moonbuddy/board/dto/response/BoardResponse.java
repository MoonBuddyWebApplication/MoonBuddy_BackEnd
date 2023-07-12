package com.project.moonbuddy.board.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardResponse {
    private String title;
    private String userName;
    private String content;
}
