package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ISBN;
    private String title;
    private String seriesTitle;
    private String seriesReleaseNumber;
    private String authors;
    private String publisher;
    private String language;
    private String numPages;
    private String description;
    private String format;
    private String genres;
    private LocalDate publicationDate;
    private Double ratingScore;
    private Double numRatings;
    private Double numReviews;
    private Double currentReaders;
    private Double wantToRead;
    private Double price;
    private String url;
}


