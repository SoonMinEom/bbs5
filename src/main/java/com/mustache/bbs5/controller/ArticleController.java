package com.mustache.bbs5.controller;

import com.mustache.bbs5.domain.dto.ArticleDto;
import com.mustache.bbs5.domain.entity.Article;
import com.mustache.bbs5.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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
        Article article = articleDto.toEntity();
        articleRepository.save(article);
        return String.format("redirect:/articles/%d",article.getId());
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if (optArticle.isEmpty()) {
            return "error";
        } else {
            model.addAttribute("article", optArticle.get());
            return "show";
        }
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "list";
    }
}
