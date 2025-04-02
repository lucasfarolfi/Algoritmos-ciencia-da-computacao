package org.example.backendExample;

import org.example.backendExample.dao.UserMongoDbDAO;
import org.example.backendExample.dao.UserMySQLDAO;
import org.example.backendExample.services.UserGrpc;
import org.example.backendExample.services.UserRest;

public class Client {
    public static void main(String[] args) {
        var user = new User();

        var userMongoDbDao = new UserMongoDbDAO();
        var userMySQLDao = new UserMySQLDAO();

        var userRestMySQLService = new UserRest(userMySQLDao);
        userRestMySQLService.save(user);

        var userRestMongoDbService = new UserRest(userMongoDbDao);
        userRestMongoDbService.save(user);

        var userGrpcMySQLService = new UserGrpc(userMySQLDao);
        userGrpcMySQLService.save(user);

        var userGrpcMongoDbService = new UserGrpc(userMongoDbDao);
        userGrpcMongoDbService.save(user);
    }
}
