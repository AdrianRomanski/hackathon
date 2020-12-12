package pl.edu.pja.hackathon.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.edu.pja.hackathon.model.Category;

public interface CategoryService {

    Page<Category> getAllCategoriesPaged(Pageable pageable);

    Category getCategoryById(Long id);
}
