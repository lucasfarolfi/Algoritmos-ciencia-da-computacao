package org.example.backendExample.dao;

import org.example.backendExample.User;

public class UserMongoDbDAO implements UserDAO {
    @Override
    public void save(User user) {
        System.out.println("Saving in the MongoDB DAO...");
    }
}
