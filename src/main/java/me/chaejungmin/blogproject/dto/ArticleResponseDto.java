package me.chaejungmin.blogproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.chaejungmin.blogproject.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleResponseDto {
    private String title;
    private String content;

    public ArticleResponseDto (Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
