package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DetailedPosition {
    TW("Torwart"),
    AV("Außenverteidiger"),
    IV("Innenverteidiger"),
    ZM("Zentrales Mittelfeld"),
    FLUEGEL("Flügelspieler"),
    ST("Stürmer");

    private final String displayName;
}