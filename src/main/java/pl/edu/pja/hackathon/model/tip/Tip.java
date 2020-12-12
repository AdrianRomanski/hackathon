package pl.edu.pja.hackathon.model.tip;

import lombok.*;
import pl.edu.pja.hackathon.model.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tip extends BaseEntity {

	private String content;
	private Boolean seen;

}