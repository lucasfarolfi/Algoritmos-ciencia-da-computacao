package org.example.backendExample.services;

import org.example.backendExample.User;
import org.example.backendExample.dao.UserDAO;

public abstract class UserService {
    protected UserDAO dao;

    public UserService(UserDAO dao) {
        this.dao = dao;
    }

    public abstract void save(User user);
}
