package com.xzinoviou.musicservice.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/** @author xzinoviou created 13/7/2019 */
@FeignClient(value = "book-service")
public interface BookClient {

  @GetMapping("/api/book/{id}")
  Map<String, Object> getBook(@PathVariable Long id);

  @GetMapping("/api/book/list")
  List<Map<String, Object>> getAllBooks();

  @PostMapping("/api/book")
  Map<String, Object> create(@RequestBody Map<String, Object> book);

  @PutMapping("/api/book")
  Map<String, Object> update(@RequestBody Map<String, Object> book);

  @DeleteMapping("/api/book/{id}")
  void delete(@PathVariable Long id);
}
