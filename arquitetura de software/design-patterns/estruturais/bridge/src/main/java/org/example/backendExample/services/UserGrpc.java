package org.example.backendExample.services;

import org.example.backendExample.User;
import org.example.backendExample.dao.UserDAO;

public class UserGrpc extends UserService{

    public UserGrpc(UserDAO dao) {
        super(dao);
    }

    @Override
    public void save(User user) {
        System.out.println("Starting a save operation through Grpc Service");
        dao.save(user);
    }
}
