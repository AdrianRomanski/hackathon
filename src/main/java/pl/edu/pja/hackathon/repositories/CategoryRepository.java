package pl.edu.pja.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.hackathon.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
