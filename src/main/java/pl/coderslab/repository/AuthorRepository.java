package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Author;

@Component
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
