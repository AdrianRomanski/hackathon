package pl.edu.pja.hackathon.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.pja.hackathon.model.memocard.MemoCard;
import pl.edu.pja.hackathon.repositories.MemoCardPageRepository;
import pl.edu.pja.hackathon.repositories.MemoCardRepository;

@Service
@RequiredArgsConstructor
public class MemoCardServiceImpl implements MemoCardService {

    private final MemoCardPageRepository memoCardPageRepository;
    private final MemoCardRepository memoCardRepository;

    @Override
    public Page<MemoCard> getAllMemoCardsPaged(Pageable pageable) {
        return memoCardPageRepository.findAll(pageable);
    }

    @Override
    public Page<MemoCard> getAllForCategory(String name, Pageable pageable) {
        return memoCardPageRepository.findByCategory_Name(name, pageable);
    }

    @Override
    public MemoCard getMemoCardById(Long id) {
        return memoCardRepository.findById(id).
                orElseThrow(RuntimeException::new);
    }
}
