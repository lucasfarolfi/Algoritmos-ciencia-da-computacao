package org.example.iphoneExample.iphoneFactoryMethod;

import org.example.iphoneExample.abstractFactory.CountryRulesAbstractFactory;
import org.example.iphoneExample.iphone.IPhone;
import org.example.iphoneExample.iphone.IPhone11;
import org.example.iphoneExample.iphone.IPhone11Pro;

public class IPhone11Factory extends IphoneFactory {
    public IPhone11Factory(CountryRulesAbstractFactory countryRules) {
        super(countryRules);
    }

    @Override
    public IPhone createIPhone(String level) {
        if(level.equals("standard")){
            return new IPhone11(countryRules);
        } else if (level.equals("highEnd")){
            return new IPhone11Pro(countryRules);
        }
        return null;
    }
}
