package org.example.iphoneExample.after.factory;

import org.example.iphoneExample.shared.IPhone;
import org.example.iphoneExample.shared.IPhone11;

public class IPhone11Factory extends IphoneFactory{
    @Override
    public IPhone createIPhone() {
        return new IPhone11();
    }
}
