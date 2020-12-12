package pl.edu.pja.hackathon.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.edu.pja.hackathon.model.memocard.MemoCard;

public interface MemoCardService {

    Page<MemoCard> getAllMemoCardsPaged(Pageable pageable);

    MemoCard getMemoCardById(Long id);
}
