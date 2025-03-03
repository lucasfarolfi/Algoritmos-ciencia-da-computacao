package org.example.after.factory;

import org.example.shared.IPhone;

public abstract class IphoneFactory {
    public IPhone orderIphone() {
        IPhone device = createIPhone();
        device.getHardware();
        device.assemble();
        device.certificates();
        device.pack();
        return device;
    }

    // This is the Factory Method
    public abstract IPhone createIPhone();
}
