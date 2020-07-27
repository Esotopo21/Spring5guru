package it.burla.springgurucourse.controllers;

import it.burla.springgurucourse.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

        private final BookRepository bookRepository;

        public BookController(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        @RequestMapping(value = "/books")
        public String getBooks(Model model){

            model.addAttribute("books", bookRepository.findAll());

            return "books/list";
        }
}
