package org.example.halfSimple;

import org.example.halfSimple.factory.IPhone11Factory;
import org.example.halfSimple.factory.IPhoneXFactory;
import org.example.halfSimple.factory.IphoneFactory;
import org.example.shared.IPhone;

public class Client {
    public static void main(String[] args) {
        IphoneFactory iphoneXFactory = new IPhoneXFactory();
        IphoneFactory iphone11Factory = new IPhone11Factory();

        System.out.println("### Ordering an iPhone X");
        IPhone iPhone = iphoneXFactory.createIPhone("standard");
        System.out.println(iPhone);

        System.out.println("\n\n### Ordering an iPhone 11 HighEnd");
        IPhone iPhone2 = iphone11Factory.createIPhone("highEnd");
        System.out.println(iPhone2);
    }
}