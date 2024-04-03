package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameSection {
    BALL_AGAINST("Spiel gegen den Ball"),
    BALL_WITH("Spiel mit dem Ball"),
    DEFENSIVE_STANDARDS("Standards defensiv"),
    OFFENSIVE_STANDARDS("Standards offensiv"),
    COUNTER_ATTACK_WIN("Umschaltspiel Ballgewinn"),
    COUNTER_ATTACK_LOSS("Umschaltspiel Ballverlust");

    private final String name;
}
