package it.burla.springgurucourse.repository;

import it.burla.springgurucourse.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
