package com.xzinoviou.bookservice.controller;

import com.xzinoviou.bookservice.model.Book;
import com.xzinoviou.bookservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

/** @author xzinoviou created 11/7/2019 */
@RestController
@RequestMapping("${spring.data.rest.base-path}/book")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
    return ResponseEntity.ok(bookService.getBook(id));
  }

  @GetMapping("/list")
  public ResponseEntity<List<Book>> getAllBooks() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @PostMapping
  public ResponseEntity<Book> createBook(@RequestBody Book book) {
    return new ResponseEntity<>(bookService.create(book), CREATED);
  }

  @PutMapping
  public ResponseEntity<Book> updateBook(@RequestBody Book book) {
    return ResponseEntity.ok(bookService.update(book));
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Long id) {
    bookService.delete(id);
  }
}
