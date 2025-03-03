package org.example.iphoneExample.halfSimple.factory;

import org.example.iphoneExample.shared.IPhone;
import org.example.iphoneExample.shared.IPhone11;
import org.example.iphoneExample.shared.IPhone11Pro;

public class IPhone11Factory extends IphoneFactory {
    @Override
    public IPhone createIPhone(String level) {
        if(level.equals("standard")){
            return new IPhone11();
        } else if (level.equals("highEnd")){
            return new IPhone11Pro();
        }
        return null;
    }
}
