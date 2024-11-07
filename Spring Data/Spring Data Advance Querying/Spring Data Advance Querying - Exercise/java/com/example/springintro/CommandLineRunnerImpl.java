package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        printAllBooksAfterYear(2000);
        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        printAllAuthorsAndNumberOfTheirBooks();
        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();

        Scanner scanner = new Scanner(System.in);

//        // Problem 1
//        String ageRestriction = scanner.nextLine().toUpperCase();
//        this.bookService.findAllBooksByAgeRestriction(AgeRestriction.valueOf(ageRestriction))
//                .forEach(System.out::println);
//
//        // Problem 2
//        this.bookService.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
//                .forEach(System.out::println);
//
//        // Problem 3
//        this.bookService.findBooksByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
//                .forEach(System.out::println);
//
//        // Problem 4
//        int year = Integer.parseInt(scanner.nextLine());
//        this.bookService.findAllBooksNotReleasedIn(year)
//                .forEach(System.out::println);
//
//        // Problem 5
//        String input = scanner.nextLine();
//        int year5 = Integer.parseInt(input.split("-")[2]);
//        this.bookService.findAllBooksReleasedBefore(year5)
//                .forEach(System.out::println);
//
//        // Problem 6
//        String endString = scanner.nextLine();
//        this.authorService.findAllAuthorsByFirstNameEndingWith(endString)
//                .forEach(System.out::println);
//
//        // Problem 7
//        String input7 = scanner.nextLine();
//        this.bookService.findAllBooksByTitleContaining(input)
//                .forEach(System.out::println);
//
//        // Problem 8
//        String input8 = scanner.nextLine();
//        this.bookService.findAllBooksWrittenByAuthorLastNameStartsWith(input)
//                .forEach(System.out::println);
//
//        // Problem 9
//        int input9 = Integer.parseInt(scanner.nextLine());
//        System.out.println(this.bookService.findAllBooksByTitleLength(input9).size());
//
//        // Problem 10
//        String[] input10 = scanner.nextLine().split("\\s+");
//        System.out.println(this.bookService.getTotalBookCopiesByGivenAuthorFirstAndLastName(input10[0], input10[1]).size());
//
//        // Problem 11
//        String bookName = scanner.nextLine().trim();
//        this.bookService.getBookByTitle(bookName)
//                .forEach(System.out::println);

        // Problem 12
        int numberOfCopies = Integer.parseInt(scanner.nextLine());
        System.out.println(this.bookService.deleteBooksByCopies(numberOfCopies));
    }
}
