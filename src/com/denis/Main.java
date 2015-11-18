package com.denis;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame mainFrame = new JFrame("Java 2D game 0.0");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(610, 630);
        mainFrame.setResizable(false);
        mainFrame.add(new GameMap());
        mainFrame.setVisible(true);

    }
}
