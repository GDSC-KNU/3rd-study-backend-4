package me.chaejungmin.blogproject.dto;

import lombok.Getter;
import me.chaejungmin.blogproject.domain.Article;

@Getter
public class ArticleListViewResponseDto {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponseDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
