package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    PAROLE("Parole"),
    PRINZIP("Prinzip"),
    UNTERPRINZIP("Unterprinzip"),
    HANDLUNGSOPTION("Handlungsoption"),
    CODEWORT("Codewort");

    private final String displayName;
}