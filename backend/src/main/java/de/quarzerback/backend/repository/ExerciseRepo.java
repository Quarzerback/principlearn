package de.quarzerback.backend.repository;

import de.quarzerback.backend.model.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepo extends MongoRepository<Exercise, String> {
}
