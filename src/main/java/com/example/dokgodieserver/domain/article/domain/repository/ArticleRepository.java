package com.example.dokgodieserver.domain.article.domain.repository;

import com.example.dokgodieserver.domain.article.domain.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    Optional<Article> findByTitle(String title);
    List<Article> findAll();
}
