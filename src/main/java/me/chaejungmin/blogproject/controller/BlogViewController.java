package me.chaejungmin.blogproject.controller;

import lombok.RequiredArgsConstructor;
import me.chaejungmin.blogproject.domain.Article;
import me.chaejungmin.blogproject.dto.ArticleListViewResponseDto;
import me.chaejungmin.blogproject.dto.ArticleViewResponseDto;
import me.chaejungmin.blogproject.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponseDto> articles = blogService.findAll().stream()
                .map(ArticleListViewResponseDto::new)
                .toList();
        model.addAttribute("articles", articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", article);
        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) { // 생성
            model.addAttribute("article", new ArticleViewResponseDto());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponseDto(article));
        }
        return "newArticle";
    }
}
