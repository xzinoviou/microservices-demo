package com.xzinoviou.common.microservices.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** @author xzinoviou created 14/7/2019 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

    private Long id;

    private String isbn;

    private String author;

    private String title;
}
