package de.quarzerback.backend.repository;

import de.quarzerback.backend.model.TrainingParticipants;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingParticipantsRepo extends MongoRepository<TrainingParticipants, String> {
}
