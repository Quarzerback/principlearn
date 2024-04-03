package de.quarzerback.backend.repository;

import de.quarzerback.backend.model.Section;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepo extends MongoRepository<Section, String> {
}
