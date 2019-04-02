package jpa.crud;

import jpa.crud.entities.Book;
import jpa.crud.services.BookService;

public class MainRunner {
    public static void main(String... args) {
        BookService bookService = new BookService();

        Book book = bookService.createBook(4044L, "H2G2", "Scifi Book", 12.5f, "1234-5678-5678", 247);

        System.out.println("Book Persisted : " + book.getId());

        book = bookService.findBook(4044L);

        System.out.println("Book Found    : " + book);

        bookService.raiseUnitCost(book, 2.0F);

        System.out.println("New book price : " + book.getUnitCost());

        bookService.removeBook(4044L);

        System.out.println("Book Removed");

        book = bookService.findBook(4044L);

        System.out.println("Book Not Found:" + book);
    }
}
