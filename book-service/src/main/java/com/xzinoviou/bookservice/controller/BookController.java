package com.xzinoviou.bookservice.controller;

import com.xzinoviou.bookservice.model.Book;
import com.xzinoviou.bookservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** @author xzinoviou created 11/7/2019 */
@RestController
@RequestMapping("api/book")
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
    return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
  }
}
