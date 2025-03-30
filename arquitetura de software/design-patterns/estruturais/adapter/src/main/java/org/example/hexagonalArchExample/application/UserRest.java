package org.example.hexagonalArchExample.application;

import org.example.hexagonalArchExample.core.infrastructure.UserInMemoryDatabaseAdapter;
import org.example.hexagonalArchExample.core.model.User;
import org.example.hexagonalArchExample.core.usecases.UserService;

import java.util.Map;

public class UserRest {
    private UserService service; // FACADE

    public UserRest() {
        var repository = new UserInMemoryDatabaseAdapter();
        service = new UserService(repository);
    }

    public Integer post(Map<String, String> values){
        try{
            var user = new User(values.get("name"), values.get("email"));
            service.save(user);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return 400;
        }
        return 201;
    }

    public Integer getAll(){
        var users = service.getAll();
        users.forEach(System.out::println);
        return 200;
    }
}
