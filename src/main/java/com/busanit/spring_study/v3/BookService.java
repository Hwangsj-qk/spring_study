package com.busanit.spring_study.v3;

import com.busanit.spring_study.v2.Book;
import com.busanit.spring_study.v2.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service    // 서비스(비즈니스) 계층임을 선언
public class BookService {

    // 데이터를 조작하는 서비스 메서드는 @Transactional 로 트랜잭션을 구현하는 것을 권장

    // 서비스 -> 레포지토리 (데이터 접근)
    // 서비스 계층은 Repository (데이터 접근 계층을 의존성 주입받아 사용)
    @Autowired
    private BookRepository bookRepository;

    // 모든 책을 조회하는 메서드
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 하나의 책만 조회하는 메서드
    public Book getBookById(Long id) {
        // 책을 조회하고 없으면 null 반환 (옵셔널)
        return bookRepository.findById(id).orElse(null);
    }

    // 책을 생성하는 메서드(INSERT)
    @Transactional  /// 해당 서비스 내의 DB 접근으 트랜잭션으로 관리
    public Book createBook(@RequestBody Book book) {
        // 책을 데이터베이스에 저장
        return bookRepository.save(book);
    }

    // UPDATE
    @Transactional  /// 해당 서비스 내의 DB 접근으 트랜잭션으로 관리
    public Book updateBook(Long id, Book updateBook) {
        // 책을 조회하여 내용을 변경하고 저장
        Book book = bookRepository.findById(id).orElse(null);
        // 각 필드(컬럼)이 비어있는지 확인하고 업데이트
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
    @Transactional  /// 해당 서비스 내의 DB 접근으 트랜잭션으로 관리
    // @DeleteMapping("/{id}")  -> Repository가 하는 일이므로 Service에서는 필요X
    public boolean deleteBook(Long id) {
        // ID 기준으로 DB에서 책이 있는지 조회
        Book book = bookRepository.findById(id).orElse(null);
        // 성공적으로 삭제되면 true
        if (book != null) {
            bookRepository.delete(book);
            return true;
        } else {
            // bookRepository.deleteById(id);
            return false;       // 책이 없으면 false
        }
    }
}
