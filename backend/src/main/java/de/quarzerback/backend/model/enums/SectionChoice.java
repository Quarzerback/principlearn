package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SectionChoice {
    WARMUP("Aufwärmen"),
    TEAM_SPIRIT("Teamgeist"),
    GAME_FORMAT("Spielform"),
    SHOT_ON_GOAL("Torschuss"),
    CONCLUSION_FORM("Abschlussform"),
    RUNS("Läufe"),
    SPRINTS("Sprints"),
    GOALKEEPER_TRAINING("TW-Training"),
    ATHLETICS("Athletik");

    private final String sectionName;
}