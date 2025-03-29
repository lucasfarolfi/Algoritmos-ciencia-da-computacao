package org.example.computerImageExample.interfaceAdapter;

import org.example.computerImageExample.ports.HDMI;
import org.example.computerImageExample.ports.VGA;

public class HDMIToVGAAdapter implements HDMI {
    private VGA vga;

    public HDMIToVGAAdapter(VGA vga) {
        System.out.println("Connecting the HDMI->VGA adapter...");
        this.vga = vga;
    }

    @Override
    public void setImage(String image) {
        System.out.println("Converting the image from HDMI to VGA...");
        vga.setImage(image);
    }

    @Override
    public void setSound(String sound) {
        System.out.println("Sorry, he VGA port doesn't support sound");
    }
}
