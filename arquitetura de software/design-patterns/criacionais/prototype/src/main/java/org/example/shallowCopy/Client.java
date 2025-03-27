package org.example.shallowCopy;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        var user = new User("Clone", 25, new Address("ABC Street", 1000));
        System.out.println(user);

        System.out.println(" ------------------ ");
        var clonedUser = user.clone();
        clonedUser.setName("Clone X2");
        // it will change the address name of both users, because is the same address
        clonedUser.getAddress().setStreet("Double Street");
        System.out.println("User: "+ user);
        System.out.printf("Cloned user: "+clonedUser);

    }
}
