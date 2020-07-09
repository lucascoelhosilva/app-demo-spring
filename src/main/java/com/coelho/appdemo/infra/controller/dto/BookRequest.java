package com.coelho.appdemo.infra.controller.dto;

import com.coelho.appdemo.domain.Book;
import com.coelho.appdemo.exception.Errors;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

  @NotBlank(message = Errors.INVALID_API_ID)
  private String id;

  @NotBlank(message = Errors.INVALID_TYPE)
  private String name;

  public Book toBook() {
    return Book.builder()
        .id(getId())
        .name(getName())
        .build();
  }

}
