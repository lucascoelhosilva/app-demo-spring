package com.coelho.appdemo.infra.controller;

import com.coelho.appdemo.domain.BookService;
import com.coelho.appdemo.infra.controller.dto.BookRequest;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService service;

  @PostMapping
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void post(@Validated @RequestBody BookRequest requestBody) {
    service.create(requestBody.toBook());
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Collection<BookRequest> get() {
    val books = service.get();
    return books.stream()
        .map(book -> BookRequest.builder()
            .id(book.getId())
            .name(book.getName())
            .build()
        ).collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public BookRequest getOne(@PathVariable String id) {
    val book = service.get(id);
    return BookRequest.builder()
        .id(book.getId())
        .name(book.getName())
        .build();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteOne(@PathVariable String id) {
    service.delete(id);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete() {
    service.delete();
  }

}
