package com.project.moonbuddy.board.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardWrite {
    private String title;
    private String content;
}
