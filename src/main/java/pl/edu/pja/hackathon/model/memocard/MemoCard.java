package pl.edu.pja.hackathon.model.memocard;

import lombok.*;
import pl.edu.pja.hackathon.model.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoCard extends BaseEntity {

    private String name;
    private String definition;
    private CategoryEnum categoryEnum;
    private Statistics statistics;
    private Boolean isIgnored;
    private Boolean isStarred;


}
