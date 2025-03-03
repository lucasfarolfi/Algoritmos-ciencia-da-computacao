package org.example.iphoneExample.abstractFactory;

import org.example.iphoneExample.certificate.BrazilianCertificate;
import org.example.iphoneExample.certificate.Certificate;
import org.example.iphoneExample.packing.BrazilianPacking;
import org.example.iphoneExample.packing.Packing;

public class BrazillianRulesAbstractFactory implements CountryRulesAbstractFactory {
    @Override
    public Certificate getCertificates() {
        return new BrazilianCertificate();
    }

    @Override
    public Packing getPacking() {
        return new BrazilianPacking();
    }
}
