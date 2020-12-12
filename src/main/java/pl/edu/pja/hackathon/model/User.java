package pl.edu.pja.hackathon.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String country;
    private LocalDate dateOfBirth;

    private int points;

    @Lob
    private Byte[] image;

    public void incrementPoints() {
        this.points+=5;
    }

}
