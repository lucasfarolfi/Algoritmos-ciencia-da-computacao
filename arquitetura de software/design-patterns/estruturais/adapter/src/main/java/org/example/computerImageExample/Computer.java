package org.example.computerImageExample;

import org.example.computerImageExample.ports.HDMI;

public class Computer {
    private HDMI port;

    public void connectPort(HDMI screen){
        System.out.println("Connecting on HDMI port...");
        this.port = screen;
    }

    public void sendImageAndSound(String image, String sound){
        if(port == null){
            System.out.println("Please, connect a HDMI cable first");
            return;
        }
        port.setImage(image);
        port.setSound(sound);
    }
}
