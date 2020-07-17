package com.coelho.appdemo.domain;

import com.coelho.appdemo.domain.repository.BookRepository;
import java.util.Collection;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

  private final BookRepository repository;

  @Async
  public Book create(@NonNull Book book) {
    log.info("Creating {}", book);

    return repository.save(book);
  }

  public Collection<Book> get() {
    log.info("Getting Books");
    return repository.findAll();
  }

  public Book get(@NonNull String id) {
    log.info("Getting Book=[{}]", id);
    return repository.findById(id);
  }

  public void delete(@NonNull String id) {
    log.info("Deleting Book=[{}]", id);
    repository.deleteById(id);
  }

  public void delete() {
    log.info("Deleting Books");
    repository.deleteAll();
  }

}
