package pl.pja.edu.hackathon.model.tip;

import lombok.*;
import pl.pja.edu.hackathon.model.BaseEntity;


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