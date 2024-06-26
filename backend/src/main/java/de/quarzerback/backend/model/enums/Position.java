package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Position {
    GOALKEEPER("Torwart"),
    DEFENSIVE("Defensive"),
    OFFENSIVE("Offensive");

    private final String displayName;
}