package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SectionChoice {
    AUFWAERMEN("Aufwärmen"),
    TEAMGEIST("Teamgeist"),
    SPIELFORM("Spielform"),
    TORSCHUSS("Torschuss"),
    ABSCHLUSSFORM("Abschlussform"),
    LAEUFER("Läufe"),
    SPRUNGEN("Springs"),
    TW_TRAINING("TW-Training"),
    ATHLETIK("Athletik");

    private final String sectionName;
}