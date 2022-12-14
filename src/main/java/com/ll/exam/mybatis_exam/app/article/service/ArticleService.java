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

    // 게시글 조회
    public List<Article> getArticles() {
        return articleRepository.getArticles();
    }

    public List<Article> getForPrintArticles() {
        return articleRepository.getForPrintArticles();
    }

    // 게시글 등록
    public long write(String subject, String content) {
        articleRepository.write(subject, content);
        return articleRepository.getLastInsertId();
    }

    public Article getArticleById(long id) {
        return articleRepository.getArticleById(id);
    }

    public List<Article> search(String kwType, String kw) {
        return articleRepository.search(kwType, kw);
    }
}