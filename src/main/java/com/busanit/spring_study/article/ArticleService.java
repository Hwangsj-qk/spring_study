package com.busanit.spring_study.article;

import com.busanit.spring_study.comment.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private CommentRepository commentRepository;


    // 조회(모든 기사)
    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();

        /*
        List<ArticleDTO> articleDTOS = new ArrayList<>();       // ArticleDTO를 담을 빈 객체

        // 조회된 전체 엔티티를 순회하며 Article -> ArticleDTO로 변경
        for (Article article : articles) {
            List<Comment> comments = article.getComments();     // Article에서 커멘트 가져옴
            List<CommentDTO> commentDTOS = new ArrayList<>();   // CommentDTO를 담을 빈 객체
            for (Comment comment : comments) {
                CommentDTO commentDTO = new CommentDTO(comment.getId(), comment.getContent(), comment.getAuthor(), comment.getArticle().getId());       // CommentDTO 생성
                commentDTOS.add(commentDTO);        // 컬렉션에 추가
            }
            // ArticleDTO 생성
            ArticleDTO articleDTO = new ArticleDTO(article.getId(), article.getTitle(), article.getContent(), article.getAuthor(), commentDTOS);
            articleDTOS.add(articleDTO);
        }
         */
        return articles.stream().map(Article::toDTO).toList();
    }


    // 조회 (일부 기사)
    public ArticleDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        // DTO로 변환
        if(article != null) {
            return article.toDTO();
        }else {
            return null;
        }
        // return article != null ? article.toDTO() : null;
    }

    // 생성
    @Transactional
    public ArticleDTO createArticle(@RequestBody ArticleDTO dto) {
        Article saved = articleRepository.save(dto.toEntity());
        return saved.toDTO();
    }

    // 업데이트
    @Transactional
    public ArticleDTO updateArticle(Long id, ArticleDTO updateArticle) {
        Article article = articleRepository.findById(id).orElse(null);
        if(article != null) {
            if(updateArticle.getTitle() != null) {
                article.setTitle(updateArticle.getTitle());
            }
            if(updateArticle.getContent() != null) {
                article.setContent(updateArticle.getContent());
            }
            if(updateArticle.getAuthor() != null) {
                article.setAuthor(updateArticle.getAuthor());
            }
            return articleRepository.save(article).toDTO();
        } else {
            return null;
        }
    }

    // 삭제
    @Transactional
    public Boolean DeleteArticle(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        if(article != null) {
            articleRepository.delete(article);
            return true;
        } else {
            return false;
        }
    }

    // 쿼리 메서드 사용
    public List<ArticleDTO> getArticleByAuthor(String author) {
        List<Article> articleList = articleRepository.findByAuthor(author);
        return articleList.stream().map(Article::toDTO).toList();

    }

    public List<ArticleDTO> getArticleByTitleContaining(String title) {
        List<Article> articleList = articleRepository.findByTitleContaining(title);
        return articleList.stream().map(Article::toDTO).toList();
    }

    public Page<ArticleDTO> getArticles(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Article> articles = articleRepository.findAll(pageable);
        List<ArticleDTO>list = articles.stream().map(article -> article.toDTO()).toList();
        Page<ArticleDTO>articleDTOs = new PageImpl<>(list, pageable, articles.getTotalElements());
        return articleDTOs;
    }

    public Page<ArticleDTO> getArticleByAuthor(String author, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Article> articles = articleRepository.findByAuthor(author, pageable);
        List<ArticleDTO> list = articles.stream().map(article -> article.toDTO()).toList();
        Page<ArticleDTO> articleDTOs = new PageImpl<>(list, pageable, articles.getTotalElements());
        return articleDTOs;
    }



}
