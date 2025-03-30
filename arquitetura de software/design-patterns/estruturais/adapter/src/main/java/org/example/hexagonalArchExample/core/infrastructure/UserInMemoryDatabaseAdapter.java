package org.example.hexagonalArchExample.core.infrastructure;

import org.example.hexagonalArchExample.core.model.User;
import org.example.hexagonalArchExample.core.ports.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInMemoryDatabaseAdapter implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getEmail(), user);
    }

    @Override
    public List<User> getAll() {
        return users.values().stream().toList();
    }
}
