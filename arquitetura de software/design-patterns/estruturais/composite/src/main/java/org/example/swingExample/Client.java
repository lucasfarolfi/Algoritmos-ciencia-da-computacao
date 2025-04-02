package org.example.swingExample;

import javax.swing.*;
import java.awt.*;

public class Client {
    public static void main(String[] args) {
        var formTitle = new JLabel("Criar usuario");
        var label = new JLabel("Nome");
        var button = new JButton("Salvar");

        // tanto o panel quanto o button e o label herdam de Component, portanto possuem o metodo .add
        var panel = new JPanel(new FlowLayout());
        panel.add(label);
        panel.add(button);

        var frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(formTitle, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }
}
