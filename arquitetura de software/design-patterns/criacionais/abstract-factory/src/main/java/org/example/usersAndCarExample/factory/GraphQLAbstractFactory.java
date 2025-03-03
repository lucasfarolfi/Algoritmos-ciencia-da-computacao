package org.example.usersAndCarExample.factory;

import org.example.usersAndCarExample.services.*;

public class GraphQLAbstractFactory implements ServicesAbstractFactory {
    @Override
    public UserService getUserService() {
        return new UserGraphQLService();
    }

    @Override
    public CarService getCarService() {
        return new CarGraphQLService();
    }
}
