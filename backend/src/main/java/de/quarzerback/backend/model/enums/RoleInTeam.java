package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleInTeam {
    SPIELER("Spieler"),
    TRAINER("Trainer"),
    BETREUER("Betreuer"),
    PROBESPIELER("Probespieler"),
    U17_SPIELER("U17-Spieler"),
    ERSTE_MANNCHAFT("1. Mannschaft");

    private final String displayName;
}