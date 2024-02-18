package com.example.test.repository;

import com.example.test.model.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}
