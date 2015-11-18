package com.denis.borders;

import com.denis.ResourceLoader;

public class BorderV extends Border{

    public BorderV(int x, int y) {
        super(x, y);
        this.img = ResourceLoader.getImage("borderV.png");
    }

    @Override
    public int getX() {
        return super.getX() - 1;
    }
}
