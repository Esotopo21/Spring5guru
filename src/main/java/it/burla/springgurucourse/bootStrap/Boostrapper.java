package it.burla.springgurucourse.bootStrap;

import it.burla.springgurucourse.domain.Author;
import it.burla.springgurucourse.domain.Book;
import it.burla.springgurucourse.domain.Publisher;
import it.burla.springgurucourse.repository.AuthorRepository;
import it.burla.springgurucourse.repository.BookRepository;
import it.burla.springgurucourse.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Boostrapper implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(Boostrapper.class);

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public Boostrapper(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author a1 = new Author("Jimmy", "Prior");
        Book b1 = new Book("My biography", "20394809834");
        Publisher p1 = new Publisher("Dementia Books", "Via dei re", "Viterbo","Italy", "01100");

        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);

        authorRepository.save(a1);
        bookRepository.save(b1);
        publisherRepository.save(p1);

        Author a2 = new Author("Sam", "Caller");
        Book b2 = new Book("The last night", "82038928");
        Publisher p2 = new Publisher("Flying pages", "Michael street 200", "Salentia", "Flatland", "02209");

        b2.getAuthors().add(a2);
        a2.getBooks().add(b2);

        authorRepository.save(a2);
        bookRepository.save(b2);
        publisherRepository.save(p2);

        logger.info("Number of books: " + bookRepository.count());
        logger.info("Number of authors: " + authorRepository.count());
        logger.info("Number of publishers: " + publisherRepository.count());



    }
}
