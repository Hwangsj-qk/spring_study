package com.busanit.spring_study.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/books")
public class BookV2Controller {

    // 스프링의 의존성 주입(DI : Dependency Injection)
    @Autowired  // 해당 멤버 변수에 BookRepository 인스턴스를 주입
    private BookRepository bookRepository;

    // CREATE
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        // 책을 데이터베이스에 저장
        return bookRepository.save(book);
    }

    // READ
    @GetMapping
    public List<Book> getAllBooks() {
        // 모든 책을 데이터베이스에서 조회
        return bookRepository.findAll();
    }

    // READ one
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        // ID로 특정 책을 조회
        return bookRepository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updateBook) {
        // 책을 조회하여 내용을 변경하고 저장
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            if (updateBook.getTitle() != null) {
                book.setTitle(updateBook.getTitle());
            }
            if (updateBook.getAuthor() != null) {
                book.setAuthor(updateBook.getAuthor());
            }
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        // ID 기준으로 DB에서 책을 삭제
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            bookRepository.delete(book);
            return "성공적으로 삭제되었습니다.";
        } else {
            // bookRepository.deleteById(id);
            return "없는 도서입니다.";
        }
    }
}