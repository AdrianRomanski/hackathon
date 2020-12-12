package pl.edu.pja.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.hackathon.model.Category;
import pl.edu.pja.hackathon.model.tip.Tip;

public interface TipRepository extends JpaRepository<Tip, Long> {
}
