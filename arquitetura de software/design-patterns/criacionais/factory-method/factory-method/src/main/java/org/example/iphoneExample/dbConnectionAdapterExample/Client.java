package org.example.iphoneExample.dbConnectionAdapterExample;

import org.example.iphoneExample.dbConnectionAdapterExample.factory.IphoneFactory;
import org.example.iphoneExample.shared.IPhone;

public class Client {
    public static void main(String[] args) {
        System.out.println("### Ordering an iPhone X");
        IPhone iPhone = IphoneFactory.orderIphone("X", "standard");
        System.out.println(iPhone);

        System.out.println("\n\n### Ordering an iPhone 11 HighEnd");
        IPhone iPhone2 = IphoneFactory.orderIphone("11", "highEnd");
        System.out.println(iPhone2);
    }
}