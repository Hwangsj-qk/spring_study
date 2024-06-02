package com.busanit.spring_study.article;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    // @Autowired
    final private ArticleService articleService;

    // INSERT
    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle (@RequestBody ArticleDTO article) {
        ArticleDTO createdArticle = articleService.createArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
    }

    // SELECT (전체 데이터)
    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        List<ArticleDTO> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }

    // SELECT (일부)
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById (@PathVariable Long id) {
        ArticleDTO article = articleService.getArticleById(id);

        if(article == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(article);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO updateArticle) {
        ArticleDTO article = articleService.updateArticle(id, updateArticle);
        if(article == null) {
            return ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok(article);

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        if(!articleService.DeleteArticle(id)) {
            return ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok().build();
    }

    // 커스텀 쿼리 요청
    @GetMapping("/title/{title}")
    public List<ArticleDTO> getArticleByTitleContaining(@PathVariable String title) {
        return articleService.getArticleByTitleContaining(title);
    }

    @GetMapping("/author/{author}")
    public List<ArticleDTO> getArticleByAuthor(@PathVariable String author) {
        return articleService.getArticleByAuthor(author);
    }

    // 게시글 페이징, 정렬된 상태로 조회하기
    @GetMapping("/page")
    public Page<ArticleDTO> getArticles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<ArticleDTO> articles = articleService.getArticles(page, size, sortBy);
        return articles;
    }

    // 특정 저자와 게시글 페이징, 정렬된 상태로 조회
    @GetMapping("/author")
    public Page<ArticleDTO> getArticlesByAuthor(
            @RequestParam String author,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<ArticleDTO> articles = articleService.getArticleByAuthor(author, page, size, sortBy);
        return articles;
    }

}

