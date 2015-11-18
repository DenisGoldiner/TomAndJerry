package com.denis.borders;

import com.denis.ResourceLoader;

public class BorderH extends Border{

    public BorderH(int x, int y) {
        super(x, y);
        this.img = ResourceLoader.getImage("borderH.png");
    }

    @Override
    public int getY() {
        return super.getY() - 1;
    }
}
