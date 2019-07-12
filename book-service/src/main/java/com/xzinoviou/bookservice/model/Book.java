package com.xzinoviou.bookservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/** @author xzinoviou created 11/7/2019 */
@Entity
@Table(name = "book")
public class Book {

  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String author;

  public Book() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
