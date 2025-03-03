package org.example.iphoneExample.after.factory;

import org.example.iphoneExample.shared.IPhone;
import org.example.iphoneExample.shared.IPhoneX;

public class IPhoneXFactory extends IphoneFactory{
    @Override
    public IPhone createIPhone() {
        return new IPhoneX();
    }
}
