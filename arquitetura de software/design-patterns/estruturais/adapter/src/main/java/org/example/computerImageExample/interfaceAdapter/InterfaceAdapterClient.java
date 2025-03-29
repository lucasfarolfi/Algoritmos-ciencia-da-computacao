package org.example.computerImageExample.interfaceAdapter;

import org.example.computerImageExample.Computer;
import org.example.computerImageExample.implementations.OldMonitor;
import org.example.computerImageExample.implementations.TV;

public class InterfaceAdapterClient {
    public static void main(String[] args) {
        var pc = new Computer();

        System.out.println("Connecting TV...");
        var tv = new TV();
        pc.connectPort(tv);
        pc.sendImageAndSound("Desenho de heroi", "Musica de heroi");

        System.out.println("\nConnecting Old Monitor...");
        pc = new Computer();
        var oldMonitor = new OldMonitor();

        pc.connectPort(new HDMIToVGAAdapter(oldMonitor));
        pc.sendImageAndSound("Cena de suspense", "Som de suspense");
    }
}