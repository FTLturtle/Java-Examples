package jpa.crud;

import jpa.crud.entities.Author;
import jpa.crud.entities.Book;
import jpa.crud.enums.Language;
import jpa.crud.services.AuthorService;
import jpa.crud.services.BookService;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainRunner {
    public static void main(String ...args){
        BookService bookService = new BookService();

        Book book = bookService.createBook(4044l, "H2G2", "Scifi Book", 12.5f, "1234-5678-5678", 247);

        System.out.println("Book Persisted : " + book.getId());

        book = bookService.findBook(4044L);

        System.out.println("Book Found    : " + book);

        //Book book2 = new Book(4044l, "H2G2", "Scifi Book", 12.5f, "1234-5678-5678", 247);
        bookService.raiseUnitCost(book, 2.0F);

        System.out.println("New book price : " + book.getUnitCost());

        bookService.removeBook(4044L);

        System.out.println("Book Removed");

        book = bookService.findBook(4044L);

        System.out.println("Book Not Found:" + book);


//        AuthorService authorService = new AuthorService();
//        Author author = new Author("Douglas", "Adams", "Adams is best know as the author of H2G2", new GregorianCalendar(1952, Calendar.MARCH, 11).getTime(), Language.USA);




    }
}
