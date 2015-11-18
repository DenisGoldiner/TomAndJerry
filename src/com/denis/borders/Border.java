package com.denis.borders;

import java.awt.*;

public class Border {

    Image img;

    int x;
    int y;

    public Border(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
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

    public void changeBorder (int d){

        this.setX(this.getX() + d);

    }
}
