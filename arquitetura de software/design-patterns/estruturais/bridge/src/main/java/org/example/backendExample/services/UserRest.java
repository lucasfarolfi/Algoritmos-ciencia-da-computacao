package org.example.backendExample.services;

import org.example.backendExample.User;
import org.example.backendExample.dao.UserDAO;

public class UserRest extends UserService{

    public UserRest(UserDAO dao) {
        super(dao);
    }

    @Override
    public void save(User user) {
        System.out.println("Starting a save operation through Rest Service");
        dao.save(user);
    }
}
