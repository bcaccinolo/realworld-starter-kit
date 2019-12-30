package org.qbeek.controller;

import lombok.Data;
import org.qbeek.entites.Article;
import org.qbeek.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ArticlesController {

    @Autowired private ArticleService articleService;

    @GetMapping("articles")
    public ArticlesResponse all() {
        ArrayList<Article> articles = articleService.get();
        ArticlesResponse response = new ArticlesResponse();

        response.setArticles(articles);
        response.setArticlesCount(articles.size());
        return response;
    }
}

@Data
class ArticlesResponse {
    private ArrayList<Article> articles;
    private int articlesCount;
}

