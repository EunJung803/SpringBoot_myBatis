package com.ll.exam.mybatis_exam.app.article.dto;

import lombok.Data;

@Data
public class Article {
    private long id;
    private String subject;
    private String content;
}