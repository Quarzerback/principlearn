package de.quarzerback.backend.model;

import de.quarzerback.backend.model.enums.GameSection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "phases")
public class Phase {
    private String id;
    private String name;
    private GameSection gameSection;
}
