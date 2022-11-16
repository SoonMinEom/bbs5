package com.mustache.bbs5.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ArticleResponse {
    private Long id;
    private String title;
    private String content;
}
