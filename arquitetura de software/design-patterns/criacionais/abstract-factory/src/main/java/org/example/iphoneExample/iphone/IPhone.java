package org.example.iphoneExample.iphone;

import org.example.iphoneExample.abstractFactory.CountryRulesAbstractFactory;

public abstract class IPhone {
	CountryRulesAbstractFactory countryRules;

	public IPhone(CountryRulesAbstractFactory countryRules) {
		this.countryRules = countryRules;
	}

	public abstract void getHardware();
	
	public void assemble() {
		System.out.println("Assembling all the hardwares");
	}

	public void certificates() {
		System.out.println(countryRules.getCertificates().applyCertification());
	}

	public void pack() {
		System.out.println(countryRules.getPacking().pack());
	}
}
