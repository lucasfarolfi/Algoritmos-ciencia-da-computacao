package org.example.simple.factory;

import org.example.shared.*;

public class IphoneFactory {
    public static IPhone orderIphone(String generation, String level) {
        IPhone device = createIPhone(generation, level);
        device.getHardware();
        device.assemble();
        device.certificates();
        device.pack();
        return device;
    }

    // This is the Factory Method
    public static IPhone createIPhone(String generation, String level){
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
        return device;
    }
}
