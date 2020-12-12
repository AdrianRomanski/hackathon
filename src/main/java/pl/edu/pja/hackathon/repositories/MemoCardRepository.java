package pl.edu.pja.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.hackathon.model.memocard.MemoCard;

public interface MemoCardRepository extends JpaRepository<MemoCard, Long> {
}
