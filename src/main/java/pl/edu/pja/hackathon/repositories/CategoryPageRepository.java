package pl.edu.pja.hackathon.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.edu.pja.hackathon.model.Category;

@Repository
public interface CategoryPageRepository extends CrudRepository<Category, Long> {

    Page<Category> findAll(Pageable pageable);

}
