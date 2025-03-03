package org.example.after.factory;

import org.example.shared.IPhone;
import org.example.shared.IPhoneX;

public class IPhoneXFactory extends IphoneFactory{
    @Override
    public IPhone createIPhone() {
        return new IPhoneX();
    }
}
