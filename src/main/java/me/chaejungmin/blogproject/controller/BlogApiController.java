package me.chaejungmin.blogproject.controller;

import lombok.RequiredArgsConstructor;
import me.chaejungmin.blogproject.domain.Article;
import me.chaejungmin.blogproject.dto.CreateArticleRequestDto;
import me.chaejungmin.blogproject.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> createArticle(@RequestBody CreateArticleRequestDto requestDto) {
        Article savedArticle = blogService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
