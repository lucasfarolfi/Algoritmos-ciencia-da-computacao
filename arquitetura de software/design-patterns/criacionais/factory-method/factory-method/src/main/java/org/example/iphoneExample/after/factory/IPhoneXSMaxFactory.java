package org.example.iphoneExample.after.factory;

import org.example.iphoneExample.shared.IPhone;
import org.example.iphoneExample.shared.IPhoneXSMax;

public class IPhoneXSMaxFactory extends IphoneFactory{
    @Override
    public IPhone createIPhone() {
        return new IPhoneXSMax();
    }
}
