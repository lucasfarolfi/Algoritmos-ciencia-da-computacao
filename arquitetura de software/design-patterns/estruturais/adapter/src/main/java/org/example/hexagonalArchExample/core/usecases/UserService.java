package org.example.hexagonalArchExample.core.usecases;

import org.example.hexagonalArchExample.core.model.User;
import org.example.hexagonalArchExample.core.ports.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(User user){
        repository.save(user);
    }

    public List<User> getAll(){
        return repository.getAll();
    }
}
