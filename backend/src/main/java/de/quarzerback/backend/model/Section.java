package de.quarzerback.backend.model;

import de.quarzerback.backend.model.enums.SectionChoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sections")
public class Section {
    private String id;
    private String topic;
    private SectionChoice sectionChoice;
    private List<Person> coaches;
    private LocalTime startTime;
    private LocalTime endTime;
    private String coachingPoints;
    private Exercise exercise;
    private List<Principle> principles;
    private Training training;
    private boolean isTemplate;
    private List<Team> teams;
    private List<Person> neutralPlayers;
}