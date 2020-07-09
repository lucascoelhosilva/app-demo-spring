package com.coelho.appdemo.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  @Builder.Default
  private String id = UUID.randomUUID().toString();

  private String name;

}
