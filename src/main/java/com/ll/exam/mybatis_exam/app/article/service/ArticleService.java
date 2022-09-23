package com.ll.exam.mybatis_exam.app.article.service;

import com.ll.exam.mybatis_exam.app.article.dto.Article;
import com.ll.exam.mybatis_exam.app.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.getArticles();
    }
}