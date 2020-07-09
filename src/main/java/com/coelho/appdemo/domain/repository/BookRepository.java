package com.coelho.appdemo.domain.repository;

import com.coelho.appdemo.domain.Book;
import java.util.Collection;
import java.util.HashMap;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class BookRepository {

  private final HashMap<String, Book> data = new HashMap<>();

  public Book save(@NonNull Book request) {
    data.put(request.getId(), request);
    return request;
  }

  public Collection<Book> findAll() {
    return data.values();
  }

  public Book findById(String id) {
    return data.get(id);
  }

  public void deleteById(String id) {
    data.remove(id);
  }

  public void deleteAll() {
    data.clear();
  }
}
