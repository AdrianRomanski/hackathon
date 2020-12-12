package pl.edu.pja.hackathon.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.edu.pja.hackathon.model.tip.Tip;

public interface TipService {

    Page<Tip> getAllTipsPaged(Pageable pageable);

    Tip getTipById(Long id);
}