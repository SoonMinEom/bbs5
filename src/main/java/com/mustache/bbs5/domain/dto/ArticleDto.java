package com.mustache.bbs5.domain.dto;

import com.mustache.bbs5.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter // 반드시 해야함
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    public ArticleDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}
