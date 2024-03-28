package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Pitch {
    GRASS("Rasen"),
    KR1("KR1"),
    BSA("BSA"),
    CAGE("Käfig");

    private final String pitchType;
}