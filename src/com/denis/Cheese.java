package com.denis;

import java.awt.*;

public class Cheese {

    Image img;

    int x;
    int y;

    public Cheese(int x, int y) {
        this.x = x;
        this.y = y;
        this.img = ResourceLoader.getImage("cheese1.png");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
