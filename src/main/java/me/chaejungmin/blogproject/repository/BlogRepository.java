package me.chaejungmin.blogproject.repository;

import me.chaejungmin.blogproject.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
