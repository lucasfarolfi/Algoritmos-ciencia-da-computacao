package org.example.iphoneExample.halfSimple.factory;

import org.example.iphoneExample.shared.IPhone;

public abstract class IphoneFactory {
    public IPhone orderIphone(String level) {
        IPhone device = createIPhone(level);
        device.getHardware();
        device.assemble();
        device.certificates();
        device.pack();
        return device;
    }

    // This is the Factory Method
    public abstract IPhone createIPhone(String level);
}
