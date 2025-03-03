package org.example.usersAndCarExample;

import org.example.usersAndCarExample.factory.GraphQLAbstractFactory;
import org.example.usersAndCarExample.factory.RestAbstractFactory;
import org.example.usersAndCarExample.factory.ServicesAbstractFactory;
import org.example.usersAndCarExample.services.CarService;
import org.example.usersAndCarExample.services.UserService;

public class Client {

	public static void main(String[] args) {
		ServicesAbstractFactory graphQLFactory = new GraphQLAbstractFactory();
		UserService userService = graphQLFactory.getUserService();
		userService.save("Jhon");
		userService.delete(15);

		ServicesAbstractFactory restFactory = new RestAbstractFactory();
		CarService carService = restFactory.getCarService();
		carService.save("Hb20");
		carService.update("Tesla X");
	}
}
