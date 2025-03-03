package org.example.iphoneExample.after;

import org.example.iphoneExample.after.factory.IPhone11ProFactory;
import org.example.iphoneExample.after.factory.IPhoneXFactory;
import org.example.iphoneExample.after.factory.IphoneFactory;
import org.example.iphoneExample.shared.IPhone;

public class Client {
    public static void main(String[] args) {
        IphoneFactory iphoneXFactory = new IPhoneXFactory();
        IphoneFactory iphone11ProFactory = new IPhone11ProFactory();

        System.out.println("### Ordering an iPhone X");
        IPhone iPhone = iphoneXFactory.createIPhone();
        System.out.println(iPhone);

        System.out.println("\n\n### Ordering an iPhone 11 HighEnd");
        IPhone iPhone2 = iphone11ProFactory.createIPhone();
        System.out.println(iPhone2);
    }
}