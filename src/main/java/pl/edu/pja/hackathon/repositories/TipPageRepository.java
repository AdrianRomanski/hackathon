package pl.edu.pja.hackathon.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import pl.edu.pja.hackathon.model.tip.Tip;

public interface TipPageRepository extends CrudRepository<Tip, Long> {

	Page<Tip> findAll(Pageable pageable);
}