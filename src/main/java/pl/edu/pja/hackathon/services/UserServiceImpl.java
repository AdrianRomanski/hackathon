package pl.edu.pja.hackathon.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pja.hackathon.model.User;
import pl.edu.pja.hackathon.repositories.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getTop20Users() {
        return userRepository.findAll();
    }
}
