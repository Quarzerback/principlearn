package de.quarzerback.backend.repository;

import de.quarzerback.backend.model.Training;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepo extends MongoRepository<Training, String> {
}
