package org.example.usersAndCarExample.services;

public class CarGraphQLService implements CarService {

	@Override
	public void save(String model) {
		System.out.println("Saving " + model + " car through GraphQL interface");
	}

	@Override
	public void update(String newModel) {
		System.out.println("Updating " + newModel + " car through GraphQL interface");
	}
	
}
