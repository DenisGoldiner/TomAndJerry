package com.denis;

import java.awt.*;

public class Enemy {

    Image img = ResourceLoader.getImage("cat1.png");

    int x = 515;
    int y = 515;
    int dx = 100;
    int dy = 100;

    public void moveRight(){
        if(x <= 500) {
            x += dx;
        }
    }
    public void moveDown(){
        if(y <= 500) {
            y += dy;
        }
    }
    public void moveUp(){
        if(y >= 100) {
            y -= dy;
        }
    }
    public void moveLeft(){
        if(x >= 100) {
            x -= dx;
        }
    }
}
