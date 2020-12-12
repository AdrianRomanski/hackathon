package pl.pja.edu.hackathon.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pja.edu.hackathon.model.Category;


import java.util.List;

public interface CategoryService {

    Page<Category> getAllCategoriesPaged(Pageable pageable);

    Category getCategoryById(Long id);
}
