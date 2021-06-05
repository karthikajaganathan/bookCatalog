package com.example.book.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.book.api.*;
import com.example.book.entities.Book;

import java.util.List;

public interface BookResource {

  
    BookDTO getByIsbn(String isbn);

    List<Book> getByAuthor(@RequestParam(value = "author",required = true) String author);


   
    List<BookDTO> getByTitle(@RequestParam(value = "title",required = true) String title);


    List<BookDTO> getAll();


   
    ResponseEntity<Void> createBook(@RequestBody @Valid BookDTO book);

   
    void updateBook(String isbn, BookDTO book);
}
