package org.example.iphoneExample.iphoneFactoryMethod;

import org.example.iphoneExample.abstractFactory.CountryRulesAbstractFactory;
import org.example.iphoneExample.iphone.IPhone;

public abstract class IphoneFactory {
    CountryRulesAbstractFactory countryRules;

    public IphoneFactory(CountryRulesAbstractFactory countryRules) {
        this.countryRules = countryRules;
    }

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
