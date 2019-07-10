package com.xzinoviou.bookservice.service;

import com.xzinoviou.bookservice.exception.JpaException;
import com.xzinoviou.bookservice.model.Book;
import com.xzinoviou.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author xzinoviou created 11/7/2019 */
@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Book getBook(Long id) {
    return bookRepository
        .findById(id)
        .orElseThrow(() -> new JpaException("Entity with id : " + id + " was not Found"));
  }

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Book create(Book book) {
    return bookRepository.save(book);
  }
}
