package org.example.iphoneExample.iphoneFactoryMethod;

import org.example.iphoneExample.abstractFactory.CountryRulesAbstractFactory;
import org.example.iphoneExample.iphone.IPhone;
import org.example.iphoneExample.iphone.IPhoneX;
import org.example.iphoneExample.iphone.IPhoneXSMax;

public class IPhoneXFactory extends IphoneFactory {
    public IPhoneXFactory(CountryRulesAbstractFactory countryRules) {
        super(countryRules);
    }

    @Override
    public IPhone createIPhone(String level) {
        if(level.equals("standard")){
            return new IPhoneX(countryRules);
        } else if (level.equals("highEnd")){
            return new IPhoneXSMax(countryRules);
        }
        return null;
    }
}
