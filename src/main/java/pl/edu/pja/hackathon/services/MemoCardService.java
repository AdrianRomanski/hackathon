package pl.edu.pja.hackathon.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.edu.pja.hackathon.model.memocard.MemoCard;

import java.util.List;
import java.util.Set;

public interface MemoCardService {

    Page<MemoCard> getAllMemoCardsPaged(Pageable pageable);

    Page<MemoCard> getAllForCategory(String name, Pageable pageable);

    MemoCard getMemoCardById(Long id);

    Set<String> getRandomAnswers(Long id);

    boolean checkAnswer(String answer, Long id);
}
