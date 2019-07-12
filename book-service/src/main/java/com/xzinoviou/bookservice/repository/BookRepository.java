package com.xzinoviou.bookservice.repository;

import com.xzinoviou.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** @author xzinoviou created 11/7/2019 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  Optional<Book> findById(Long id);
}
