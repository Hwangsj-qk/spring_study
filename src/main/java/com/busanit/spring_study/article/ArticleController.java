package com.busanit.spring_study.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    // INSERT
    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle (@RequestBody ArticleDTO article) {
        ArticleDTO createArticle = articleService.createArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(createArticle);
    }

    // SELECT (전체 데이터)
    @GetMapping
    public List<ArticleDTO> getAllArticles() {
        List<ArticleDTO> aritcles = articleService.getAllArticles();
        return articleService.getAllArticles();
    }

    // SELECT (일부)
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById (@PathVariable Long id) {
        ArticleDTO article = articleService.getArticleById(id);

        if(article == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(article);
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO updateArticle) {
        ArticleDTO article = articleService.updateArticle(id, updateArticle);
        if(article == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(article);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        boolean isDeletedArticle = articleService.DeleteArticle(id);
        if(!isDeletedArticle) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().build();
        }
    }
}
