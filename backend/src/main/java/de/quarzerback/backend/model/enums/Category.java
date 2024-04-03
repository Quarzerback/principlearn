package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    SLOGAN("Parole"),
    PRINCIPLE("Prinzip"),
    SUB_PRINCIPLE("Unterprinzip"),
    OPTION_FOR_ACTION("Handlungsoption"),
    CODEWORD("Codewort");

    private final String displayName;
}