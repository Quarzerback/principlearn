package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DetailedPosition {
    GOALKEEPER("Torwart"),
    FULL_BACK("Außenverteidiger"),
    CENTER_BACK("Innenverteidiger"),
    CENTRAL_MIDFIELDER("Zentrales Mittelfeld"),
    WING("Flügelspieler"),
    STRIKER("Stürmer");

    private final String displayName;
}