package nl.miwgroningen.cohort4.vincent.libraryDemo.repository;

import nl.miwgroningen.cohort4.vincent.libraryDemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
