package com.xzinoviou.bookservice.service;

import com.xzinoviou.bookservice.model.Book;

import java.util.List;

/** @author xzinoviou created 11/7/2019 */
public interface BookService {

  Book getBook(Long id);

  List<Book> getAllBooks();

  Book create(Book book);

  void delete(Long id);

  Book update(Book book);
}
