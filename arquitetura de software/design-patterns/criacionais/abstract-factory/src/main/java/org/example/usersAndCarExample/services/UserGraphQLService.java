package org.example.usersAndCarExample.services;

public class UserGraphQLService implements UserService {

	@Override
	public void save(String name) {
		System.out.println("Saving " + name + " through GraphQL interface");
	}

	@Override
	public boolean delete(Integer id) {
		System.out.println("Removing User #" + id + " through GraphQL interface");
		return true;
	}

}
