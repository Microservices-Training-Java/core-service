package com.java.spring.books.service;

import com.java.spring.books.entity.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


public interface IBookService {

  Book create(Book book);

  List<Book> getAll();

  Book getOneById(Long id);

  Book update(Book book);

  void delete(Long id);

}
