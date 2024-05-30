package com.busanit.spring_study.v3;

import com.busanit.spring_study.v2.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 표현 계층 : 사용자로부터 요청을 받고 응답을 해주는 일을 전담

@RestController     // 표현 계층임을 선언(JSON으로 리턴)
@RequestMapping("api/v3/books")     // 기본 경로
public class BookV3Controller {

    // ResponseEntity : HTTP 응답을 표현하는 객체
    // ResponseEntity.ok() : 200
    // ResponseEntity.status(상태코드).body(엔티티) : 해당 상태코드와 데이터 본문을 응답
    // ResponseEntity.notFound().build() : 404 Not Found 반환

    // 컨트롤러 -> 서비스
    // 스프링의 의존성 주입(DI : Dependency Injection)
    @Autowired  // 해당 멤버 변수에 BookRepository 인스턴스를 주입
    private BookService bookService;


    // CREATE
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {        // 상태코드 반환 (반환값: ResponseEntity)
        // 데이터베이스 접근을 서비스 계층에 위임
        Book createBook = bookService.createBook(book);

        // 상태코드 201번(CREATED)에 응답 본문을 담아서 리턴
        return ResponseEntity.status(HttpStatus.CREATED).body(createBook);
    }

    // READ
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // READ one
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        // ID로 특정 책을 조회
        Book book = bookService.getBookById(id);
        if(book == null) {
            return ResponseEntity.notFound().build();   // 책이 없으면 404 Not Found 응답
        } else {
            return ResponseEntity.ok(book);     // 책이 있으면 200 OK 응답과 함께 책 객체 리턴
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updateBook) {
        Book book = bookService.updateBook(id, updateBook);
        if(book == null) {
            return ResponseEntity.notFound().build();   // 책이 없으면 404 Not Found 응답
        } else {
            return ResponseEntity.ok(book);     // 책이 있으면 200 OK 응답과 함께 책 객체 리턴
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean isDeleted = bookService.deleteBook(id);     // 지워지면 true 아니면 false
        if(!isDeleted) {
            return ResponseEntity.notFound().build();       // 책을 삭제하지 못했으면 404 Not Found 응답
        } else  {
            return ResponseEntity.ok().build();             // 책을 삭제했으면 200 OK 응답
        }
    }
}