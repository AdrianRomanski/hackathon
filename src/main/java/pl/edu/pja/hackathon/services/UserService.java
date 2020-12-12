package pl.edu.pja.hackathon.services;

import pl.edu.pja.hackathon.model.User;

import java.util.List;

public interface UserService {

    List<User> getTop20Users();
}
