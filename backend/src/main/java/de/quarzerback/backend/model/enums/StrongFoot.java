package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum StrongFoot {
    RIGHT("Rechts"),
    LEFT("Links"),
    BOTH("Beidfüßig");

    private final String displayName;
}