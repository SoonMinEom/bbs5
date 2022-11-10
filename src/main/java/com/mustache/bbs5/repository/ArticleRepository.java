package com.mustache.bbs5.repository;

import com.mustache.bbs5.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
