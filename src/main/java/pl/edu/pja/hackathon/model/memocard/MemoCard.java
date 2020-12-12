package pl.edu.pja.hackathon.model.memocard;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import pl.edu.pja.hackathon.model.BaseEntity;
import pl.edu.pja.hackathon.model.tip.Tip;

import javax.persistence.*;

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
	@ManyToOne
	private Statistics statistics;
	private Boolean ignored;
	private Boolean starred;

}