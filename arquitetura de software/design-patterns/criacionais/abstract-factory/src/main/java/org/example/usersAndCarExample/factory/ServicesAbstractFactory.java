package org.example.usersAndCarExample.factory;

import org.example.usersAndCarExample.services.CarService;
import org.example.usersAndCarExample.services.UserService;

public interface ServicesAbstractFactory {
    UserService getUserService();
    CarService getCarService();
}
