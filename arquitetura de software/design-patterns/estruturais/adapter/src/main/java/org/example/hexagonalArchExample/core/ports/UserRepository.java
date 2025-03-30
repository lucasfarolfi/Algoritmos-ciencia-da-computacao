package org.example.hexagonalArchExample.core.ports;

import org.example.hexagonalArchExample.core.model.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    List<User> getAll();
}
