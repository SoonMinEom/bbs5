package com.mustache.bbs5.domain.dto;

import com.mustache.bbs5.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ArticleAddResponse {
    private Long id;
    private String title;
    private String content;
}
