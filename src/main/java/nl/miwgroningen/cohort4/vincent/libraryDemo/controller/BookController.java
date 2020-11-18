package nl.miwgroningen.cohort4.vincent.libraryDemo.controller;

import nl.miwgroningen.cohort4.vincent.libraryDemo.model.Book;
import nl.miwgroningen.cohort4.vincent.libraryDemo.repository.AuthorRepository;
import nl.miwgroningen.cohort4.vincent.libraryDemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Stuur de views voor Book aan
 */

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping({"/", "/books"})
    protected String showBooks(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());
        return "bookOverview";
    }

    @GetMapping("/book/{bookTitle}")
    protected String showBookDetails(Model model, @PathVariable("bookTitle") String bookTitle){
        Optional<Book> bookBox = bookRepository.findByTitle(bookTitle);
        if (bookBox.isEmpty()) {
            return "redirect:/books";
        }
        model.addAttribute("book", bookBox.get());
        return "bookDetails";
    }

    @GetMapping("/books/add")
    protected String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("allAuthors", authorRepository.findAll());
        return "bookForm";
    }

    @PostMapping("/books/add")
    protected String saveOrUpdateBook(@ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "bookForm";
        } else {
            bookRepository.save(book);
            return "redirect:/books";
        }
    }
}
