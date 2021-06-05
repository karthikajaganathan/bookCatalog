package com.example.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.book.entities.Book;


import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    List<Book> findByAuthor(String author);
    List<Book> findByTitleLike(String title);
}

