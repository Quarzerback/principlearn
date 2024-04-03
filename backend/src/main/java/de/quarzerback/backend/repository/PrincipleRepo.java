package de.quarzerback.backend.repository;

import de.quarzerback.backend.model.Principle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrincipleRepo extends MongoRepository<Principle, String> {
}
