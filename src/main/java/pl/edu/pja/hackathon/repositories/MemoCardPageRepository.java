package pl.edu.pja.hackathon.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pja.hackathon.model.memocard.MemoCard;

@Repository
public interface MemoCardPageRepository extends CrudRepository {

    Page<MemoCard> findAll(Pageable pageable);

}
