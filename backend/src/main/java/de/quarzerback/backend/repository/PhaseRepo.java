package de.quarzerback.backend.repository;

import de.quarzerback.backend.model.Phase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhaseRepo extends MongoRepository<Phase, String> {
}
