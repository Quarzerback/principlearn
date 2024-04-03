package de.quarzerback.backend.model;

import de.quarzerback.backend.model.enums.DetailedPosition;
import de.quarzerback.backend.model.enums.Position;
import de.quarzerback.backend.model.enums.RoleInTeam;
import de.quarzerback.backend.model.enums.StrongFoot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "persons")
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private RoleInTeam roleInTeam;
    private String permissionRole;
    private String team;
    private Position position;
    private DetailedPosition detailedPosition;
    private String shirtNumber;
    private StrongFoot strongFoot;
    private String phoneNumber;
    private String address;
    private String city;
    private String zipCode;
    private String country;
    private LocalDate birthDate;
    private boolean active;
    private LocalDate inClubSince;
    private byte[] profilePicture;
    private String notes;
    private List<Training> trainings;
}
