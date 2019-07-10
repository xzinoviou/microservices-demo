package com.xzinoviou.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/** @author xzinoviou created 11/7/2019 */
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Book {

  @Id private Long id;

  private String title;

  private String author;
}
