package com.java.spring.books.dto.response;

import com.java.spring.books.entity.Book;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class BookResponse {

  private String id;
  private String title;
  private String author;
  private String category;
  private String publisher;
  private Long publishTime;

  public BookResponse from(Book book) {
    BookResponse response = new BookResponse();
    response.setId(book.getId());
    response.setTitle(book.getTitle());
    response.setAuthor(book.getAuthor());
    response.setCategory(book.getCategory());
    response.setPublisher(book.getPublisher());
    response.setPublishTime(book.getPublishTime());
    return response;
  }
}
