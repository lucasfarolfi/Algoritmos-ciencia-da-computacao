package org.example.iphoneExample.abstractFactory;

import org.example.iphoneExample.certificate.Certificate;
import org.example.iphoneExample.packing.Packing;

public interface CountryRulesAbstractFactory {
    Certificate getCertificates();
    Packing getPacking();
}
