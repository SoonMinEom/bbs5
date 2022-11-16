package com.mustache.bbs5.domain.dto;

import com.mustache.bbs5.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ArticleAddRequest {
    private String title;
    private String content;

//    public Article toEntity() {
//        return new Article(getTitle(),getContent());
//    }

    public Article toEntity() {
        Article article = Article.builder()
                .title(this.title)
                .content(this.content)
                .build();
        return article;
    }
}
