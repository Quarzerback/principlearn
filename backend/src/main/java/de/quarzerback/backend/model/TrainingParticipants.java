package de.quarzerback.backend.model;

import de.quarzerback.backend.model.enums.AbsenceReason;
import de.quarzerback.backend.model.enums.Intensity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "participants")
public class TrainingParticipants {
    private String id;
    private Intensity perceivedIntensity;
    private Training training;
    private Person person;
    private boolean isPresent;
    private boolean isWorkingIndividually;
    private boolean isGameReplacement;
    private AbsenceReason absenceReason;
    private String notes;
    private int standbyPulse;
    private int stressPulse;
    private int maxPulse;
    private double longJumpBeforeTraining;
    private double longJumpAfterTraining;
}
