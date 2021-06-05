package com.example.book.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.book.api.BookDTO;


public interface BookService {
	 @Transactional
    String createNew(BookDTO bookDTO);

    @Transactional
    void update(String isbn, BookDTO bookDTO);

    BookDTO findByIsbn(String isbn);

    List<BookDTO> findByAuthor(String author);

    List<BookDTO> findByTitleLike(String title);

    List<BookDTO> findAll();

    void delete(String isbn);

}
