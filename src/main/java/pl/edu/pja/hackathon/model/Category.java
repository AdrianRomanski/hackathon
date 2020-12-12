package pl.edu.pja.hackathon.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity{

    private String name;

    @Lob
    private Byte[] image;

}
