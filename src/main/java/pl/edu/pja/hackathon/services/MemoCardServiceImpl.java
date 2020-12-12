package pl.edu.pja.hackathon.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.pja.hackathon.model.memocard.MemoCard;
import pl.edu.pja.hackathon.repositories.CategoryRepository;
import pl.edu.pja.hackathon.repositories.MemoCardPageRepository;
import pl.edu.pja.hackathon.repositories.MemoCardRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemoCardServiceImpl implements MemoCardService {

    private final MemoCardPageRepository memoCardPageRepository;
    private final MemoCardRepository memoCardRepository;
    private final CategoryRepository categoryRepository;

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

    @Override
    public Set<String> getRandomAnswers(Long id) {
        MemoCard memoCard = memoCardPageRepository.findById(id).orElseThrow(RuntimeException::new);
        List<MemoCard> memoCardList = memoCard.getCategory().getMemoCardList();
        memoCardList.remove(memoCard);
        Collections.shuffle(memoCardList);
        Set<String> collect = memoCardList.stream().map(MemoCard::getDefinition).limit(3).collect(Collectors.toSet());
        collect.add(memoCard.getDefinition());
        return collect;
    }
}
