package com.denis;

public class Step {


    boolean player_1;
    boolean player_2;

    public Step() {
        this.player_1 = true;
        this.player_2 = false;
    }

    public boolean isPlayer_1() {
        return player_1;
    }

    public void setPlayer_1(boolean player_1) {
        this.player_1 = player_1;
    }

    public boolean isPlayer_2() {
        return player_2;
    }

    public void setPlayer_2(boolean player_2) {
        this.player_2 = player_2;
    }


}
