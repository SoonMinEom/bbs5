package com.mustache.bbs5.controller;

import com.mustache.bbs5.domain.dto.ArticleDto;
import com.mustache.bbs5.domain.entity.Article;
import com.mustache.bbs5.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/new")
    public String newArticle() {
        return "new";
    }

    @PostMapping("/add")
    public String add(ArticleDto articleDto) {
        articleRepository.save(articleDto.toEntity());
        return "";
    }
}
