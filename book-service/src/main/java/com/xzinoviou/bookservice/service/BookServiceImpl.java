package com.xzinoviou.bookservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzinoviou.bookservice.exception.JpaException;
import com.xzinoviou.bookservice.model.Book;
import com.xzinoviou.bookservice.repository.BookRepository;
import com.xzinoviou.common.microservices.demo.dto.BookRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author xzinoviou created 11/7/2019 */
@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final ObjectMapper objectMapper;

  public BookServiceImpl(BookRepository bookRepository, ObjectMapper objectMapper) {
    this.bookRepository = bookRepository;
    this.objectMapper = objectMapper;
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
  public Book create(BookRequestDto dto) {
    Book book = objectMapper.convertValue(dto, Book.class);
    return bookRepository.save(book);
  }

  @Override
  public void delete(Long id) {
    bookRepository.deleteById(id);
  }

  @Override
  public Book update(BookRequestDto dto) {
    Book book = objectMapper.convertValue(dto, Book.class);
    return bookRepository.save(book);
  }
}
