package nl.miwgroningen.cohort4.vincent.libraryDemo.repository;

import nl.miwgroningen.cohort4.vincent.libraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Haal boeken uit en schrijf boeken naar de database
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);
}
