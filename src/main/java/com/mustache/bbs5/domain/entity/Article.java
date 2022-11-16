package com.mustache.bbs5.domain.entity;

import com.mustache.bbs5.domain.dto.ArticleAddResponse;
import com.mustache.bbs5.domain.dto.ArticleResponse;
import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "article5")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static ArticleResponse of(Article article) {
        return new ArticleResponse(article.getId(), article.getTitle(), article.getContent());
    }
    public static ArticleAddResponse get(Article article) {
        return new ArticleAddResponse(article.getId(), article.getTitle(), article.getContent());
    }
}
