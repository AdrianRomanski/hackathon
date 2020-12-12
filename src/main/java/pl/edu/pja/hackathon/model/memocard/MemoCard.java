package pl.edu.pja.hackathon.model.memocard;

import lombok.*;
import pl.edu.pja.hackathon.model.BaseEntity;
import pl.edu.pja.hackathon.model.Category;


import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoCard extends BaseEntity {

	private String name;
	private String definition;
	@ManyToOne
	private Category category;
	@OneToOne
	private Statistics statistics;
	private DifficultyEnum difficultyEnum;
	private Boolean ignored;
	private Boolean starred;

	@Lob
	private Byte[] image;
}