package com.xzinoviou.bookservice.service;

import com.xzinoviou.bookservice.model.Book;
import com.xzinoviou.common.microservices.demo.dto.BookRequestDto;

import java.util.List;

/** @author xzinoviou created 11/7/2019 */
public interface BookService {

  Book getBook(Long id);

  List<Book> getAllBooks();

  Book create(BookRequestDto dto);

  void delete(Long id);

  Book update(BookRequestDto dto);
}
