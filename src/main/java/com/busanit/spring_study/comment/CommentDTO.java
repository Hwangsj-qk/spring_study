package com.busanit.spring_study.comment;

import com.busanit.spring_study.article.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 사용자에게 보여주고 싶은 값을 담은 데이터 전송 객체(DTO) -> 엔티티와는 다름
public class CommentDTO {
    private Long id;
    private String content;
    private String author;
    private Long articleId;

    // DTO -> 엔티티(엔티티에 @Builder 적용, 빌더 패턴 사용)
    public Comment toEntity(Article article) {
        return Comment.builder()
                .id(id)
                .content(content)
                .author(author)
                .article(article)
                .build();
    }


}
