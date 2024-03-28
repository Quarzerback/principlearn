package de.quarzerback.backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AbsenceReason {
    MUSCULAR_INJURY("Verletzt (muskulär)"),
    BONE_INJURY("Verletzt (Knochen)"),
    LIGAMENT_INJURY("Verletzt (Bänder)"),
    ILL("Krank"),
    SCHOOL("Schule"),
    PRIVATE("Privat"),
    OTHER_TEAM("Andere Mannschaft"),
    UNEXCUSED("Unentschuldigt");

    private final String reason;
}