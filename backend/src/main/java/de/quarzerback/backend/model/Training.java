package de.quarzerback.backend.model;

import de.quarzerback.backend.model.enums.Intensity;
import de.quarzerback.backend.model.enums.Pitch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "trainings")
public class Training {
    private String id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String specificCoachingPoints;
    private String neededMaterial;
    private Intensity intensity;
    private Pitch pitch;
    private List<TrainingParticipants> participants;
    private List<Section> sections;
}
