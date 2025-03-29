package org.example.computerImageExample.implementations;


import org.example.computerImageExample.ports.VGA;

public class OldMonitor implements VGA {
    @Override
    public void setImage(String image) {
        System.out.println("-> Video: " + image);
    }
}
