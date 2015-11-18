package com.denis.borders;


import com.denis.ResourceLoader;

public class BorderVT extends Border{

    public BorderVT(int x, int y) {
        super(x, y);
        this.img = ResourceLoader.getImage("borderVT.png");
    }

    @Override
    public int getX() {
        return super.getX() - 1;
    }
}
