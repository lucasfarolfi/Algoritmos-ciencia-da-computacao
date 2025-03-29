package org.example.computerImageExample.implementations;

import org.example.computerImageExample.ports.HDMI;

public class TV implements HDMI {
    @Override
    public void setImage(String image) {
        System.out.println("-> Video: " + image);
    }

    @Override
    public void setSound(String sound) {
        System.out.println("-> Sound: " + sound);
    }
}
