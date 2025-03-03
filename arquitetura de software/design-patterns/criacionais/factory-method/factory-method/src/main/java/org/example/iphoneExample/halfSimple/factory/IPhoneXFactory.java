package org.example.iphoneExample.halfSimple.factory;

import org.example.iphoneExample.shared.IPhone;
import org.example.iphoneExample.shared.IPhoneX;
import org.example.iphoneExample.shared.IPhoneXSMax;

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
