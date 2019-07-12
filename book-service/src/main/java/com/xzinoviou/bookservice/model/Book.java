package com.xzinoviou.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/** @author xzinoviou created 11/7/2019 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, length = 13, nullable = false)
  private String isbn;

  private String title;

  private String author;
}
