package com.busanit.spring_study.controller;

import com.busanit.spring_study.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController                 // REST API 임을 표시
@RequestMapping("/api/books")   // HTTP 요청 엔드포인트의 시작부분을 설정
public class BookController {

    // 책 데이터를 저장할 리스트
    List<Book> books = new ArrayList<>();

    // 새로운 책 생성 : (사용자에게 본문(body)를 입력받음)
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId((long) (books.size() + 1));  // ID 생성
        books.add(book);        // 데이터 리스트에 추가
        return book;
    }

    // 모든 책 조회 (Read)
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // 특정 책 조회 (ID 기준)
    @GetMapping("/{id}")        // 경로 변수로 조회할 책을 받음
    public Book getBookById(@PathVariable Long id) {
        // 책 리스트에서 ID 일치하는 것 찾아서 반환
        return books.stream().filter(
                book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // 수정 Update
    // 변경될 내용을 요청 본문(JSON)으로 받음
    @PutMapping("/{id}")        // 특정 책(수정할 책)을 경로변수로 받음
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book book = getBookById(id);    // 수정 요청한 책을 찾음.
        if (book != null) {
            // 요청 본문으로 준 데이터 업데이트
            if (updatedBook.getTitle() != null) {
                book.setTitle(updatedBook.getTitle());
            }
            if (updatedBook.getAuthor() != null) {
                book.setAuthor(updatedBook.getAuthor());
            }
        }
        return book;
    }
    
    // 삭제 Delete : 경로변수에 해당하는 항목 삭제
    @DeleteMapping("/{id}")     
    public String deleteBook(@PathVariable Long id) {
        boolean removeIf = books.removeIf(book -> book.getId().equals(id));
        if (removeIf) {
            return id + "번 책 삭제 성공";
        } else {
            return "없는 책입니다.";
        }
    }

}
