package com.ll.exam.mybatis_exam;

import com.ll.exam.mybatis_exam.app.article.dto.Article;
import com.ll.exam.mybatis_exam.app.article.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class AppTest {

    @Autowired
    private ArticleService articleService;

    @Test
    @DisplayName("게시물들 조회")
    void t1() {
        List<Article> articles = articleService.getArticles();
        System.out.println(articles);
    }

    @Test
    @DisplayName("게시물 작성")
    void t2() {
        long id = articleService.write("제목3", "내용3");

        assertThat(id).isGreaterThan(0);
    }

    @Test
    @DisplayName("게시물 단건 조회")
    void t3() {
        Article article = articleService.getArticleById(2L);
        assertThat(article).isNotNull();
    }
}
