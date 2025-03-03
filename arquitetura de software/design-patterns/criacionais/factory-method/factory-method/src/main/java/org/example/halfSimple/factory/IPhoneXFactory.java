package org.example.halfSimple.factory;

import org.example.shared.*;

public class IPhoneXFactory extends IphoneFactory {
    @Override
    public IPhone createIPhone(String level) {
        if(level.equals("standard")){
            return new IPhoneX();
        } else if (level.equals("highEnd")){
            return new IPhoneXSMax();
        }
        return null;
    }
}
