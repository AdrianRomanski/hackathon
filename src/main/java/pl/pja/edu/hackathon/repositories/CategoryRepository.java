package pl.pja.edu.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pja.edu.hackathon.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
