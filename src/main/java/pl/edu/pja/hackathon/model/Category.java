package pl.edu.pja.hackathon.model;


import lombok.*;
import pl.edu.pja.hackathon.model.memocard.MemoCard;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity{

    private String name;
    @OneToMany
    private List<MemoCard> memoCardList;

    @Lob
    private Byte[] image;

}
