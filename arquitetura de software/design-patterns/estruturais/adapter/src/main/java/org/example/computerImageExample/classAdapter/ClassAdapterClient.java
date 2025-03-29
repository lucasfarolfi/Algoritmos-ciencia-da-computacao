package org.example.computerImageExample.classAdapter;

import org.example.computerImageExample.Computer;
import org.example.computerImageExample.implementations.TV;

public class ClassAdapterClient {
    public static void main(String[] args) {
        var pc = new Computer();

        System.out.println("Connecting TV...");
        var tv = new TV();
        pc.connectPort(tv);
        pc.sendImageAndSound("Desenho de heroi", "Musica de heroi");

        System.out.println("\nConnecting Old Monitor...");
        pc = new Computer();
        var oldMonitor = new HDMIToOldMonitorAdapter();

        pc.connectPort(oldMonitor);
        pc.sendImageAndSound("Cena de suspense", "Som de suspense");
    }
}