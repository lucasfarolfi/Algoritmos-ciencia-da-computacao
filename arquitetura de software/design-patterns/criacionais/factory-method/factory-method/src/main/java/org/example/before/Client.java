package org.example.before;

import org.example.shared.*;

public class Client {
    public IPhone orderIphone(String generation, String level) {
        IPhone device = null;

        if(generation.equals("X")){
            if(level.equals("standard")){
                device = new IPhoneX();
            } else if(level.equals("highEnd")){
                device = new IPhoneXSMax();
            } else {
                throw new RuntimeException("This generation and/or level doesn't exists");
            }
        } else if(generation.equals("11")) {
            if(level.equals("standard")){
                device = new IPhone11();
            } else if(level.equals("highEnd")){
                device = new IPhone11Pro();
            } else {
                throw new RuntimeException("This generation and/or level doesn't exists");
            }
        }
        device.getHardware();
        device.assemble();
        device.certificates();
        device.pack();
        return device;
    }

    public static void main(String[] args) {
        Client client = new Client();

        System.out.println("### Ordering an iPhone X");
        IPhone iphone = client.orderIphone("X", "standard");
        System.out.println(iphone);

        System.out.println("\n\n### Ordering an iPhone 11 HighEnd");
        IPhone iphone2 = client.orderIphone("11", "highEnd");
        System.out.println(iphone2);
    }
}