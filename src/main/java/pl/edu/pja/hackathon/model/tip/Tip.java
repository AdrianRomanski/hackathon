package pl.edu.pja.hackathon.model.tip;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import pl.edu.pja.hackathon.model.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NotNull
public class Tip extends BaseEntity {

	private String content;
	private Boolean seen;

}