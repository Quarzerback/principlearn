package de.quarzerback.backend.repository;

import de.quarzerback.backend.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends MongoRepository<Person, String> {
}
