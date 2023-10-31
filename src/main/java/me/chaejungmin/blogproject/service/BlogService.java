package me.chaejungmin.blogproject.service;

import lombok.RequiredArgsConstructor;
import me.chaejungmin.blogproject.domain.Article;
import me.chaejungmin.blogproject.dto.CreateArticleRequestDto;
import me.chaejungmin.blogproject.dto.UpdateArticleRequestDto;
import me.chaejungmin.blogproject.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // 스프링이 관리하는 빈으로 등록
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 생성
    public Article save(CreateArticleRequestDto requestDto) {
        return blogRepository.save(requestDto.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("not found: " + id)
        );
    }

    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article updateById(Long id, UpdateArticleRequestDto requestDto) {
        Article article = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("not found: " + id)
        );
        article.update(requestDto.getTitle(), requestDto.getContent());
        return article;
    }
}
