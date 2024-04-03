package de.quarzerback.backend.model.dtos;

import de.quarzerback.backend.model.Section;
import de.quarzerback.backend.model.TrainingParticipants;
import de.quarzerback.backend.model.enums.Intensity;
import de.quarzerback.backend.model.enums.Pitch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDto {
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
