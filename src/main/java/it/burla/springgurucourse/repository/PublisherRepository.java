package it.burla.springgurucourse.repository;

import it.burla.springgurucourse.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository <Publisher, Long> {
}
