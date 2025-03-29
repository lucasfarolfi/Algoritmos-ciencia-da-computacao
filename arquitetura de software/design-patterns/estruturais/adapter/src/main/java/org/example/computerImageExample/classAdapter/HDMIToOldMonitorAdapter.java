package org.example.computerImageExample.classAdapter;

import org.example.computerImageExample.implementations.OldMonitor;
import org.example.computerImageExample.ports.HDMI;

public class HDMIToOldMonitorAdapter extends OldMonitor implements HDMI {

    public HDMIToOldMonitorAdapter() {
        super();
        System.out.println("Connecting the HDMI to Old Monitor's VGA with adapter...");
    }

    @Override
    public void setImage(String image) {
        System.out.println("Converting the image from HDMI to VGA...");
        super.setImage(image);
    }

    @Override
    public void setSound(String sound) {
        System.out.println("Sorry, he VGA port doesn't support sound");
    }
}
