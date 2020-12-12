package pl.edu.pja.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.hackathon.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
