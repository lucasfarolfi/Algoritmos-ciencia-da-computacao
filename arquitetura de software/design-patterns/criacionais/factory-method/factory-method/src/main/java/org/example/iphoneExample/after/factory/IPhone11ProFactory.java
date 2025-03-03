package org.example.iphoneExample.after.factory;

import org.example.iphoneExample.shared.IPhone;
import org.example.iphoneExample.shared.IPhone11Pro;

public class IPhone11ProFactory extends IphoneFactory{
    @Override
    public IPhone createIPhone() {
        return new IPhone11Pro();
    }
}
