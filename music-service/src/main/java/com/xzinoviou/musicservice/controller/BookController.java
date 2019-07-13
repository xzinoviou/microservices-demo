package com.xzinoviou.musicservice.controller;

import com.xzinoviou.musicservice.client.feign.BookClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author xzinoviou
 * created 13/7/2019
 */
@RestController
@RequestMapping("api/book")
public class BookController {

    private final BookClient bookClient;


    public BookController(BookClient bookClient) {
        this.bookClient = bookClient;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> getBook(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookClient.getBook(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Map<String,Object>>> getAllBooks() {
        return ResponseEntity.ok(bookClient.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> createBook(@RequestBody Map<String,Object> book) {
        return new ResponseEntity<>(bookClient.create(book), CREATED);
    }

    @PutMapping
    public ResponseEntity<Map<String,Object>> updateBook(@RequestBody Map<String,Object> book) {
        return ResponseEntity.ok(bookClient.update(book));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookClient.delete(id);
    }
}
