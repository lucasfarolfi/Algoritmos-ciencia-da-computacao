package org.example.after.factory;

import org.example.shared.IPhone;
import org.example.shared.IPhone11Pro;
import org.example.shared.IPhoneX;

public class IPhone11ProFactory extends IphoneFactory{
    @Override
    public IPhone createIPhone() {
        return new IPhone11Pro();
    }
}
