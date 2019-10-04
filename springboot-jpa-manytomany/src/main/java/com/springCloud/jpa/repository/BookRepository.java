package com.springCloud.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springCloud.jpa.domain.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
