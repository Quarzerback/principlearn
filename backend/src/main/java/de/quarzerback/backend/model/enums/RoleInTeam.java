package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleInTeam {
    PLAYER("Spieler"),
    COACH("Trainer"),
    CREW("Betreuer"),
    TEST_PLAYER("Probespieler"),
    U17_PLAYER("U17-Spieler"),
    FIRST_TEAM("1. Mannschaft");

    private final String displayName;
}