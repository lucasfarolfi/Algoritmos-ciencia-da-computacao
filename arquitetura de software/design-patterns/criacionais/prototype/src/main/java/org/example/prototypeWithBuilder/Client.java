package org.example.prototypeWithBuilder;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        var user = new User("Clone", 25, new Address("ABC Street", 1000));
        System.out.println(user);

        System.out.println(" ------------------ ");
        var clonedUser = user.cloneBuilder().name("Joaozinho").get();
        System.out.println("Cloned user: "+clonedUser);

        var clonedUser2 = user.cloneBuilder().address(user.getAddress().cloneBuilder().street("Avenida Joaozinho").get()).get();
        System.out.println("Cloned user 2: "+ clonedUser2);

    }
}
