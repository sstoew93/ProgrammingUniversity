package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    @Query("SELECT b FROM Book b WHERE YEAR(b.releaseDate) < :year OR YEAR(b.releaseDate) > :year")
    List<Book> findAllBooksNotReleasedIn(int year);

    @Query("SELECT b FROM Book b WHERE YEAR(b.releaseDate) < :year")
    List<Book> findAllBooksReleasedBefore(int year);

    List<Book> findAllBooksByTitleContainingIgnoreCase(String input);


    List<Book> findAllBooksWrittenByAuthorLastNameStartsWith(String input);

    @Query("SELECT b FROM Book b WHERE LENGTH(b.title) > :input")
    List<Book> findAllBooksByTitleLength(int input);


    List<Book> getTotalBookCopiesByAuthorFirstNameAndAuthorLastName(String firstName, String lastName);

    List<Book> getBookByTitle(String bookName);

    @Transactional
    int deleteBooksByCopiesLessThan(int numberOfCopies);
}
