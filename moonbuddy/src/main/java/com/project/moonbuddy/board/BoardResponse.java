package com.project.moonbuddy.board;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardResponse {
    private String title;
    private String userName;
    private String content;
}
