package com.denis.borders;


import com.denis.ResourceLoader;

public class BorderHT extends Border{

    public BorderHT(int x, int y) {
        super(x, y);
        this.img = ResourceLoader.getImage("borderHT.png");
    }

    @Override
    public int getY() {
        return super.getY() - 1;
    }



}
