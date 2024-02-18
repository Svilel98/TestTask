package com.example.test.service;

import com.example.test.model.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class BookSpecification implements Specification<Book> {
    private Long year;


    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();
        if (year != null) {
            predicateList.add(criteriaBuilder.like(criteriaBuilder.concat(root.get("publicationDate"), "::text"),
                    year + "%"));
        }
        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }
}