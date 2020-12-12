package pl.edu.pja.hackathon.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.pja.hackathon.model.Category;
import pl.edu.pja.hackathon.repositories.CategoryPageRepository;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryPageRepository categoryPageRepository;

    @Override
    public Page<Category> getAllCategoriesPaged(Pageable pageable) {
        return categoryPageRepository.findAll(pageable);
    }
}
