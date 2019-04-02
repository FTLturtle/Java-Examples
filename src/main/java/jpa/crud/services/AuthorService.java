package jpa.crud.services;

import jpa.crud.entities.Author;
import jpa.crud.enums.Language;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;

public class AuthorService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("publishing");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public Author createAuthork(String firstName, String lastName, String bio, Date dateOfBirth, Language language) {

        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setBio(bio);
        author.setDateOfBirth(dateOfBirth);
        author.setLanguage(language);

        tx.begin();
        em.persist(author);
        tx.commit();

        return author;
    }

    public Author createBook(Author book) {
        tx.begin();
        em.persist(book);
        tx.commit();
        return book;
    }

    public Author findBook(Long id) {
        return em.find(Author.class, id);
    }

    public void removeBook(Long id) {
        Author book = em.find(Author.class, id);
        if (book != null) {
            tx.begin();
            em.remove(book);
            tx.commit();
        }
    }

    public void removeBook(Author book) {
        Author bookToBeDeleted = em.merge(book);
        em.remove(bookToBeDeleted);

        /*
        em.remove(em.merge(book));
        /**/
    }
}
