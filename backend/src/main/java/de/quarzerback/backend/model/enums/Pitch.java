package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Pitch {
    RASEN("Rasen"),
    KR1("KR1"),
    BSA("BSA"),
    KAFIG("Käfig");

    private final String pitchType;
}