package com.mustache.bbs5.controller;

import com.mustache.bbs5.domain.dto.ArticleAddRequest;
import com.mustache.bbs5.domain.dto.ArticleAddResponse;
import com.mustache.bbs5.domain.dto.ArticleResponse;
import com.mustache.bbs5.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticles(@PathVariable Long id) {
        return ResponseEntity.ok().body(articleService.getArticle(id));
    }

    @PostMapping
    public ResponseEntity<ArticleAddResponse> add(@RequestBody ArticleAddRequest dto) {
        ArticleAddResponse response = articleService.add(dto);
        return ResponseEntity.ok().body(response);
    }
}
