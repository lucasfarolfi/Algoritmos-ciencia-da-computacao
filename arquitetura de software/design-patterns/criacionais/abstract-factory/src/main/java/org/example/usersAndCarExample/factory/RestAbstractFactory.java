package org.example.usersAndCarExample.factory;

import org.example.usersAndCarExample.services.*;

public class RestAbstractFactory implements ServicesAbstractFactory {
    @Override
    public UserService getUserService() {
        return new UserRestApiService();
    }

    @Override
    public CarService getCarService() {
        return new CarRestApiService();
    }
}
