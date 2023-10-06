package me.chaejungmin.blogproject.service;

import lombok.RequiredArgsConstructor;
import me.chaejungmin.blogproject.domain.Article;
import me.chaejungmin.blogproject.dto.CreateArticleRequestDto;
import me.chaejungmin.blogproject.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service // 스프링이 관리하는 빈으로 등록
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 생성
    public Article save(CreateArticleRequestDto requestDto) {
        return blogRepository.save(requestDto.toEntity());
    }
}
