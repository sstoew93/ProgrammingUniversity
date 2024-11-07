package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<String> findBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    List<String> findAllBooksNotReleasedIn(int year);

    List<String> findAllBooksReleasedBefore(int year);

    List<String> findAllBooksByTitleContaining(String input);

    List<String> findAllBooksWrittenByAuthorLastNameStartsWith(String input);

    List<Book> findAllBooksByTitleLength(int input);

    List<String> getTotalBookCopiesByGivenAuthorFirstAndLastName(String firstName, String lastName);

    List<String> getBookByTitle(String bookName);

    int deleteBooksByCopies(int numberOfCopies);
}
