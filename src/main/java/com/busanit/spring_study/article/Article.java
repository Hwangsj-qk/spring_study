package com.busanit.spring_study.article;

import com.busanit.spring_study.comment.Comment;
import com.busanit.spring_study.comment.CommentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


//@Getter       // 롬복 : 게터만 생성
//@Setter       // 롬복 : 세터만 생성
//@ToString     // 롬복 : ToString만 생성
// @NoArgsConstructor      // 롬복 : 생성자만 생성
// @RequestMapping     // 롬복 : final 또는 @nonnull이 붙은 필드만 매개변수로 갖는 생성자 (없을 경우 기본 생성자)
// @EqualsAndHashCode      // 롬복 : Equals, HashCode

@Builder        // 롬복 : 빌더 패턴
@Data         // 롬복 : 게터, 세터, ToString, equals to, 생성자, 필수 생성자, Equals, HashCode 모두 생성
@AllArgsConstructor     // 필드가 들어간 생성자 생성
@NoArgsConstructor      // 필드가 들어가지 않은 생성자 생성
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String author;

    // 양방향 관계 : (부모 객체가 자식을 알고 있음) -> 서로의 데이터를 가지고 있기 때문에 무한반복이 될 가능성이 있음
    // 1(article) 대 다(comment) 관계 : 하나의 게시글은 여러개의 댓글을 가질 수 있다.
    @OneToMany (mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
    // mappedBy : Comment 엔티티와 article 필드와 매핑이 됨
    // cascade : Article이 저장되거나 삭제되거나 할때 관련된 상태를 모두 전이(영속성 전이)
    // orphanRemoval : 부모 엔티티에서 자식 엔티티의 관계가 끊어질 때 자동으로 DB에서 제거

    // 엔티티 -> DTO 변환 메서드
    public ArticleDTO toDTO () {
        List<CommentDTO> commentDTOList = new ArrayList<>();
        if(comments != null) {
            commentDTOList = comments.stream().map(Comment::toDTO).toList();
        }
         return new ArticleDTO(id, title, content, author, commentDTOList);
    }

    // 엔티티 -> DTO 변환 메서드
    public static Article createArticle(ArticleDTO dto) {
        Article article = new Article();
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setAuthor(dto.getAuthor());
        return article;

    }

}
