package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SectionChoice {
    WARMUP("Aufwärmen"),
    TEAMSPIRIT("Teamgeist"),
    SPIELFORM("Spielform"),
    TORSCHUSS("Torschuss"),
    ABSCHLUSSFORM("Abschlussform"),
    LAEUFER("Läufe"),
    SPRINTS("Sprints"),
    TW_TRAINING("TW-Training"),
    ATHLETIK("Athletik");

    private final String sectionName;
}