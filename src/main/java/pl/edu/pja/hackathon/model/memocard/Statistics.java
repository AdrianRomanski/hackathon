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
public class Statistics extends BaseEntity {
    private Integer viewed;
    private Integer correctAnswers;
    private Integer wrongAnswers;
    private Boolean lastAnswerCorrect;
}
