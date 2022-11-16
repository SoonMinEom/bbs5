package com.mustache.bbs5.service;

import com.mustache.bbs5.domain.dto.ArticleResponse;
import com.mustache.bbs5.domain.entity.Article;
import com.mustache.bbs5.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public ArticleResponse getArticle(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
            Article article = optionalArticle.get();
            ArticleResponse articleResponse = Article.of(article);
        return articleResponse;
    }
}
