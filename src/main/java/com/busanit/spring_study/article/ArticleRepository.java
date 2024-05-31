package com.busanit.spring_study.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // 커스텀 메서드
    // 1. 기본 쿼리 메서드
    // JPA에서 메서드의 이름을 분석하여 적절한 쿼리를 생성
    // 1-1. 저자(Author) 기준으로 쿼리를 사용하고 싶은 경우
    List<Article> findByAuthor(String author);

    // 2. 명시적 쿼리 (JPQL)
    // JAP에서 엔티티 객체를 대상으로 쿼리를 작성하는 객체지향 쿼리
    // Article은 자바 객체(Entity)
    // a -> 객체 전체
    @Query("SELECT a FROM Article a WHERE a.author = :author")
    List<Article> findByAuthorJPQL(String author);

    // 3. 명시적 쿼리 (네이티브 쿼리) -> 추천하는 방법 X
    // 데이터베이스에 직접 전송하는 SQL 쿼리
    // :author 매개변수로 매핑
    // 여기서 article은 테이블 이름
    // @Param 매핑되는 매개변수임을 선언
    @Query(value = "SELECT * FROM article WHERE author = :author", nativeQuery = true)
    List<Article> findByAuthorNative(@Param("author") String author);

    // 제목에 특정 문자가 포함되는 경우 쿼리
    List<Article> findByTitleContaining(String title);

    @Query("SELECT a FROM Article WHERE a.title LIKE %:title%")
    List<Article> findByTitleContainingJPQL(@Param("title") String title);

    @Query(value = "SELECT * FROM article WHERE title LIKE %:title%", nativeQuery = true)
    List<Article> findByTitleContainingNative(@Param("title") String title);

    /* 쿼리 메서드 이름 규칙
    - findBy~ : 특정 퀄럼(필드)에 대한 검색
    - countBy~ : 특정 컬름(필드)에 대한 숫자 개수
    - deleteBy~ : 특정 컬럼(필드) 삭제

    - 속성이름: 엔티티 클래스의 필드 이름과 일치해야 함
    - 조건 키워드 : Like, Containing, And, Or, Between, OrderBy...
     */



}
