package com.busanit.spring_study.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
