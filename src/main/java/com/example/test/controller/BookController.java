package com.example.test.controller;

import com.example.test.model.Book;
import com.example.test.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;


    @GetMapping("/top10")
    public ResponseEntity<List<Book>> getListByYear(@RequestParam(required = false) Long year,
                                                    @RequestParam(required = true) String column,
                                                    @RequestParam(required = true) String sort) {
        return ResponseEntity.ok(bookService.getTopTenBook(year, column, sort));
    }
}
