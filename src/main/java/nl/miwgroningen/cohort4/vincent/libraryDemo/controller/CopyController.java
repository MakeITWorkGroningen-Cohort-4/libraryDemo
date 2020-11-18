package nl.miwgroningen.cohort4.vincent.libraryDemo.controller;

import nl.miwgroningen.cohort4.vincent.libraryDemo.model.Book;
import nl.miwgroningen.cohort4.vincent.libraryDemo.model.Copy;
import nl.miwgroningen.cohort4.vincent.libraryDemo.repository.BookRepository;
import nl.miwgroningen.cohort4.vincent.libraryDemo.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 */

@Controller
public class CopyController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CopyRepository copyRepository;

    @GetMapping("/copy/add/{bookId}")
    protected String addCopy(@PathVariable("bookId") Integer bookId) {
        Optional<Book> bookBox = bookRepository.findById(bookId);
        if (bookBox.isPresent()) {
            Copy copy = new Copy();
            copy.setBook(bookBox.get());
            copyRepository.save(copy);
        }
        return "redirect:/books";
    }

    @GetMapping("/copy/add/t/{bookTitle}")
    protected String addCopyByTitle(@PathVariable("bookTitle") String bookTitle) {
        Optional<Book> bookBox = bookRepository.findByTitle(bookTitle);
        if (bookBox.isPresent()) {
            Copy copy = new Copy();
            copy.setBook(bookBox.get());
            copyRepository.save(copy);
        }
        return "redirect:/books";
    }
}
