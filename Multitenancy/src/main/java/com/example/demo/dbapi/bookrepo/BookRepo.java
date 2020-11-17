package com.example.demo.dbapi.bookrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dbapi.book.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

}
