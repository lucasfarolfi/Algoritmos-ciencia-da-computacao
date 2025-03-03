package org.example.iphoneExample;

import org.example.iphoneExample.abstractFactory.BrazillianRulesAbstractFactory;
import org.example.iphoneExample.abstractFactory.CountryRulesAbstractFactory;
import org.example.iphoneExample.abstractFactory.USRulesAbstractFactory;
import org.example.iphoneExample.iphone.IPhone;
import org.example.iphoneExample.iphoneFactoryMethod.IPhone11Factory;
import org.example.iphoneExample.iphoneFactoryMethod.IPhoneXFactory;

public class Main {
    public static void main(String[] args) {
        CountryRulesAbstractFactory countryRules = new BrazillianRulesAbstractFactory();
        var iPhoneXFactory = new IPhoneXFactory(countryRules);

        System.out.println("### Ordering an Iphone X");
        IPhone iPhoneX = iPhoneXFactory.orderIphone("standard");
        System.out.println(iPhoneX);

        countryRules = new USRulesAbstractFactory();
        var iPhone11Factory = new IPhone11Factory(countryRules);
        System.out.println("### Ordering an Iphone 11");
        IPhone iPhone11 = iPhone11Factory.orderIphone("highEnd");
        System.out.println(iPhone11);
    }
}