package com.example.test.service;

import com.example.test.model.Book;
import com.example.test.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    @PostConstruct
    public void her() {
        bookRepository.findAll(PageRequest.of(3, 5));
    }


    public List<Book> getTopTenBook(Long year, String column, String sorted) {
        try {
            return bookRepository.findAll(new BookSpecification(year), Sort.by(validateColumnSort(sorted), validateColumnName(column)));
        }catch (Exception e){
            log.error("Something wrong. Please contact the developer - @vanturist0", e);
            throw e;
        }
    }
    private String validateColumnName(String column) {
        return switch (column.toLowerCase().replaceAll("_","")) {
            case "book" -> "title";
            case "author" -> "authors";
            case "numpages" -> "numPages";
            case "publicationdate" -> "publicationDate";
            case "rating" -> "ratingScore";
            case "numberofvoters" -> "numReviews";
            default -> column;
        };
    }

    private Sort.Direction validateColumnSort(String sort){
        return switch (sort.toUpperCase()){
            case "ASC" -> Sort.Direction.ASC;
            case "DESC" -> Sort.Direction.DESC;
            default -> throw new IllegalArgumentException("Unexpected value: " + sort);
        };
    }
}