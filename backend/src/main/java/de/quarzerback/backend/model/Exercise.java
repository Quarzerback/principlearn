package de.quarzerback.backend.model;

import de.quarzerback.backend.model.enums.Rating;
import de.quarzerback.backend.model.enums.SectionChoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Exercises")
public class Exercise {
    private String id;
    private String name;
    private String description;
    private String shortDescriptionForPrinting;
    private List<String> videoUrls;
    private List<SectionChoice> sectionChoices;
    private int minPlayers;
    private int maxPlayers;
    private int neededGoalkeepers;
    private List<Principle> principles;
    private Rating rating;
    private byte[] image;
    private List<Section> sections;
}
