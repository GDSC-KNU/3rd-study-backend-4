package me.chaejungmin.blogproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.chaejungmin.blogproject.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateArticleRequestDto {
    private String title;
    private String content;

    public Article toEntity() { // 빌더 패턴으로 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
