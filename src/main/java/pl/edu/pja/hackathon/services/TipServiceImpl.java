package pl.edu.pja.hackathon.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.pja.hackathon.model.tip.Tip;
import pl.edu.pja.hackathon.repositories.TipPageRepository;
import pl.edu.pja.hackathon.repositories.TipRepository;

@Service
@RequiredArgsConstructor
public class TipServiceImpl implements TipService {

    private final TipPageRepository tipPageRepository;
    private final TipRepository tipRepository;


    @Override
    public Page<Tip> getAllTipsPaged(Pageable pageable) {
        return tipPageRepository.findAll(pageable);
    }

    @Override
    public Tip getTipById(Long id) {
        return tipRepository.findById(id).
                orElseThrow(RuntimeException::new);
    }
}