package org.example.after.factory;

import org.example.shared.IPhone;
import org.example.shared.IPhone11;
import org.example.shared.IPhoneX;

public class IPhone11Factory extends IphoneFactory{
    @Override
    public IPhone createIPhone() {
        return new IPhone11();
    }
}
