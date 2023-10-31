package me.chaejungmin.blogproject.controller;

import lombok.RequiredArgsConstructor;
import me.chaejungmin.blogproject.domain.Article;
import me.chaejungmin.blogproject.dto.ArticleResponseDto;
import me.chaejungmin.blogproject.dto.CreateArticleRequestDto;
import me.chaejungmin.blogproject.dto.UpdateArticleRequestDto;
import me.chaejungmin.blogproject.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponseDto>> findAllArticles() {
        List<ArticleResponseDto> articleResponseDtoList = blogService.findAll()
                .stream().map(ArticleResponseDto::new).toList();
        return ResponseEntity.ok(articleResponseDtoList);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponseDto> findArticle(@PathVariable Long id) {
        ArticleResponseDto articleResponseDto = new ArticleResponseDto(blogService.findById(id));
        return ResponseEntity.ok(articleResponseDto);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponseDto> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequestDto requestDto) {
        Article updatedArticle = blogService.updateById(id, requestDto);
        return ResponseEntity.ok().body(new ArticleResponseDto(updatedArticle));
    }
}
