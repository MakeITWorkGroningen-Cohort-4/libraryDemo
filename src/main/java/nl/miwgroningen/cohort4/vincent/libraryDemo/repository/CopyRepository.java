package nl.miwgroningen.cohort4.vincent.libraryDemo.repository;

import nl.miwgroningen.cohort4.vincent.libraryDemo.model.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyRepository extends JpaRepository<Copy, Integer> {
}
