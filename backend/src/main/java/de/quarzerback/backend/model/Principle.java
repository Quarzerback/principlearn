package de.quarzerback.backend.model;

import de.quarzerback.backend.model.enums.Category;
import de.quarzerback.backend.model.enums.DetailedPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "principles")
public class Principle {
    private String id;
    private Category category;
    private String name;
    private String description;
    private List<DetailedPosition> appliesToPositions;
    private List<DetailedPosition> importantForPositions;
    private List<Principle> subPrinciples;
    private List<Principle> superPrinciples;
    private boolean onlyForSpecificPhases;
    private List<Phase> appliesToPhases;
    private List<Exercise> relevantExercises;
    private List<String> videoUrls;
}
