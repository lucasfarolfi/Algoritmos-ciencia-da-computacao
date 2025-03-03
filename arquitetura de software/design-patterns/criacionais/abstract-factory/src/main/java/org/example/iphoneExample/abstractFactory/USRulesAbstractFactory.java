package org.example.iphoneExample.abstractFactory;

import org.example.iphoneExample.certificate.Certificate;
import org.example.iphoneExample.certificate.USCertificate;
import org.example.iphoneExample.packing.Packing;
import org.example.iphoneExample.packing.USPacking;

public class USRulesAbstractFactory implements CountryRulesAbstractFactory {
    @Override
    public Certificate getCertificates() {
        return new USCertificate();
    }

    @Override
    public Packing getPacking() {
        return new USPacking();
    }
}
