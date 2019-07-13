package com.xzinoviou.musicservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/** @author xzinoviou created 13/7/2019 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, length = 13, nullable = false)
  private String barCode;

  private String artist;

  private String title;
}
