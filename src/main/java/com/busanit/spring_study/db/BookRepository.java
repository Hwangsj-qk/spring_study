package com.busanit.spring_study.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // JPA 레포지토리 선언 (상속 시 해당 Entity 타입과, Id의 타입 지정)
    // 기본적인 CRUD 메서드가 자동 제공

}
