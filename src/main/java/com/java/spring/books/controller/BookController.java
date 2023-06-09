package com.java.spring.books.controller;

import com.java.spring.books.dto.request.BookRequest;
import com.java.spring.books.dto.response.BookResponse;
import com.java.spring.books.entity.Book;
import com.java.spring.books.repository.BookRepository;
import com.java.spring.books.service.BookService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.aibles.header.dto.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/books")

public class BookController {

  @Autowired
  private BookService bookService;
  @Autowired
  private BookRepository bookRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BookResponse create(@Validated @RequestBody BookRequest request, @RequestHeader Payload payload) {
    return bookService.create(request);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<BookResponse> getAll() {
    return bookService.getAll();
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public BookResponse getOneById(@PathVariable("id") Long id) {
    return bookService.getOneById(id);
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public BookResponse update(@RequestBody BookRequest request, @PathVariable("id") Long id) {
    return bookService.update(request, id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") Long id) {
    bookService.deleteById(id);
  }

  @RequestMapping("/{pageNumber}/{pageSize}")
  public Page<Book> bookPagination(@PathVariable Integer pageNumber,
      @PathVariable Integer pageSize) {
    return bookService.getBookPagination(pageNumber, pageSize);
  }
}
