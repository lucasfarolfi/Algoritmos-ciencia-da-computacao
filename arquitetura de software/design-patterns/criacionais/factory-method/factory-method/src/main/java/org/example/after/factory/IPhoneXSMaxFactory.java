package org.example.after.factory;

import org.example.shared.IPhone;
import org.example.shared.IPhoneX;
import org.example.shared.IPhoneXSMax;

public class IPhoneXSMaxFactory extends IphoneFactory{
    @Override
    public IPhone createIPhone() {
        return new IPhoneXSMax();
    }
}
