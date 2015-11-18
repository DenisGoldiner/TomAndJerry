package com.denis;

import com.denis.borders.Border;
import com.denis.borders.BorderH;
import com.denis.borders.BorderHT;
import com.denis.borders.BorderV;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class GameMap extends JPanel implements ActionListener{

    Timer mainTimer = new Timer(20, this);

    Image img;

    ArrayList borderList = new ArrayList<Border>();

    public void setBorders(){

        Border border_1 = new BorderV(100, 0);
        Border border_2 = new BorderV(100, 100);
        Border border_3 = new BorderHT(100, 200);
        Border border_4 = new BorderV(200, 100);
        Border border_5 = new BorderH(200, 100);
        Border border_6 = new BorderH(300, 100);
        Border border_7 = new BorderH(400, 100);
        Border border_8 = new BorderH(400, 200);
        Border border_9 = new BorderH(300, 200);
        Border border_10 = new BorderH(0, 300);
        Border border_11 = new BorderH(200, 300);
        Border border_12 = new BorderV(300, 200);
        Border border_13 = new BorderH(100, 400);
        Border border_14 = new BorderV(100, 400);
        Border border_15 = new BorderV(200, 500);
        Border border_16 = new BorderH(200, 400);
        Border border_17 = new BorderV(300, 400);
        Border border_18 = new BorderV(400, 200);
        Border border_19 = new BorderV(400, 300);
        Border border_20 = new BorderV(500, 300);
        Border border_21 = new BorderHT(400, 400);
        Border border_22 = new BorderV(400, 400);
        Border border_23 = new BorderV(500, 400);
        Border border_24 = new BorderV(500, 500);

        borderList.add(border_1);
        borderList.add(border_2);
        borderList.add(border_3);
        borderList.add(border_4);
        borderList.add(border_5);
        borderList.add(border_6);
        borderList.add(border_7);
        borderList.add(border_8);
        borderList.add(border_9);
        borderList.add(border_10);
        borderList.add(border_11);
        borderList.add(border_12);
        borderList.add(border_13);
        borderList.add(border_14);
        borderList.add(border_15);
        borderList.add(border_16);
        borderList.add(border_17);
        borderList.add(border_18);
        borderList.add(border_19);
        borderList.add(border_20);
        borderList.add(border_21);
        borderList.add(border_22);
        borderList.add(border_23);
        borderList.add(border_24);

    }

    Player player = new Player();

    Enemy enemy = new Enemy();

    Cheese cheese = new Cheese(415, 315);

    Step step = new Step();

    public GameMap(){
//        img = new ImageIcon(("src/com.denis.res/map.jpg")).getImage();
        img = ResourceLoader.getImage("mapNEW.jpg");
        mainTimer.start();
        addKeyListener(new MyKeyAdapter());
        setBorders();

        setFocusable(true);
    }

        private class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {

            keyPress(e);


            if(player.x == enemy.x && player.y == enemy.y){
                JOptionPane.showMessageDialog(null, "ENEMY WINS!");
            }

            if(player.x == cheese.getX() && player.y == cheese.getY()){
                JOptionPane.showMessageDialog(null, "com.denis.Player WINS!");
            }
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);


        for(int i = 0; i < borderList.size(); ++i){
            Border newBorder = (Border)borderList.get(i);
            g.drawImage(newBorder.getImg(), newBorder.getX(), newBorder.getY(), null);
        }

        g.drawImage(cheese.img, cheese.getX(), cheese.getY(), null);
        g.drawImage(player.img, player.x, player.y, null);
        g.drawImage(enemy.img, enemy.x, enemy.y, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void keyPress(KeyEvent e){
        int key = e.getKeyCode();


        if(step.isPlayer_1()) {
            if (key == KeyEvent.VK_D) {
                if (CollisionP(player, borderList, "right")) {
                    step.setPlayer_1(false);
                    step.setPlayer_2(true);
                    player.moveRight();
                }
            }
            if (key == KeyEvent.VK_A) {
                if (CollisionP(player, borderList, "left")) {
                    step.setPlayer_1(false);
                    step.setPlayer_2(true);
                    player.moveLeft();
                }
            }
            if (key == KeyEvent.VK_W) {
                if (CollisionP(player, borderList, "up")) {
                    step.setPlayer_1(false);
                    step.setPlayer_2(true);
                    player.moveUp();
                }

            }
            if (key == KeyEvent.VK_S) {
                if (CollisionP(player, borderList, "down")) {
                    step.setPlayer_1(false);
                    step.setPlayer_2(true);
                    player.moveDown();
                }
            }

        }

        else if(step.isPlayer_2()) {
            if (key == KeyEvent.VK_RIGHT) {
                if (CollisionE(enemy, borderList, "right")) {
                    step.setPlayer_2(false);
                    step.setPlayer_1(true);
                    enemy.moveRight();
                }
            }
            if (key == KeyEvent.VK_LEFT) {
                if (CollisionE(enemy, borderList, "left")) {
                    step.setPlayer_2(false);
                    step.setPlayer_1(true);
                    enemy.moveLeft();
                }
            }
            if (key == KeyEvent.VK_UP) {
                if (CollisionE(enemy, borderList, "up")) {
                    step.setPlayer_2(false);
                    step.setPlayer_1(true);
                    enemy.moveUp();
                }

            }
            if (key == KeyEvent.VK_DOWN) {
                if (CollisionE(enemy, borderList, "down")) {
                    step.setPlayer_2(false);
                    step.setPlayer_1(true);
                    enemy.moveDown();
                }
            }


        }

    }

    public boolean CollisionP(Player player, ArrayList list, String side){
        boolean Coll = true;

        if(side == "up"){
            for(int i = 0; i < list.size(); ++i) {

                Border border = (Border) list.get(i);

                double distance = Math.sqrt(Math.pow(player.x - border.getX(), 2) + Math.pow(player.y - border.getY(), 2));

                String type = border.getClass().toString().split(" ")[1].substring(18);
                System.out.println(type);
                String need_1 = "BorderH";
                String need_2 = "BorderHT";
                if (distance < player.dx/2 && ( type.equals(need_1)|| type.equals(need_2) ) ) {
                    if (player.y - player.dy < border.getY()) {
                        Coll = false;
                        break;
                    }
                }
            }
        }

        if(side == "down"){
            for(int i = 0; i < list.size(); ++i) {

                Border border = (Border) list.get(i);

                double distance = Math.sqrt(Math.pow(player.x - border.getX(), 2) + Math.pow((player.y + 70) - border.getY(), 2));

                String type = border.getClass().toString().split(" ")[1].substring(18);
                String need_1 = "BorderH";
                String need_2 = "BorderHT";
                if (distance < player.dx/2 && ( type.equals(need_1)|| type.equals(need_2) ) ) {
                    if (player.y + player.dy > border.getY()) {
                        Coll = false;
                        break;
                    }
                }
            }
        }

        if(side == "left"){
            for(int i = 0; i < list.size(); ++i) {

                Border border = (Border) list.get(i);

                double distance = Math.sqrt(Math.pow(player.x - border.getX(), 2) + Math.pow(player.y - border.getY(), 2));

                String type = border.getClass().toString().split(" ")[1].substring(18);
                String need_1 = "BorderV";
                String need_2 = "BorderVT";
                if (distance < player.dy/2 && ( type.equals(need_1)||type.equals(need_2) ) ) {
                    if (player.x - player.dx < border.getX()) {
                        Coll = false;
                        break;
                    }
                }
            }
        }

        if(side == "right"){
            for(int i = 0; i < list.size(); ++i) {

                Border border = (Border) list.get(i);

                double distance = Math.sqrt(Math.pow((player.x + 70) - border.getX(), 2) + Math.pow(player.y - border.getY(), 2));

                String type = border.getClass().toString().split(" ")[1].substring(18);
                String need_1 = "BorderV";
                String need_2 = "BorderVT";
                if (distance < player.dy/2 && ( type.equals(need_1)|| type.equals(need_2) ) ) {
                    if (player.x + player.dx > border.getX()) {
                        Coll = false;
                        break;
                    }
                }
            }
        }

        return Coll;
    }

    public boolean CollisionE(Enemy enemy, ArrayList list, String side){
        boolean Coll = true;

        if(side == "up"){
            for(int i = 0; i < list.size(); ++i) {

                Border border = (Border) list.get(i);

                double distance = Math.sqrt(Math.pow(enemy.x - border.getX(), 2) + Math.pow(enemy.y - border.getY(), 2));

                String type = border.getClass().toString().split(" ")[1].substring(18);
                String need_1 = "BorderH";
                String need_2 = "BorderHT";
                if (distance < enemy.dx/2 && ( type.equals(need_1)|| type.equals(need_2) ) ) {
                    if (enemy.y - enemy.dy < border.getY()) {
                        Coll = false;
                        break;
                    }
                }
            }
        }

        if(side == "down"){
            for(int i = 0; i < list.size(); ++i) {

                Border border = (Border) list.get(i);

                double distance = Math.sqrt(Math.pow(enemy.x - border.getX(), 2) + Math.pow((enemy.y + 70) - border.getY(), 2));

                String type = border.getClass().toString().split(" ")[1].substring(18);
                String need_1 = "BorderH";
                String need_2 = "BorderHT";
                if (distance < enemy.dx/2 && ( type.equals(need_1)|| type.equals(need_2) ) ) {
                    if (enemy.y + enemy.dy > border.getY()) {
                        Coll = false;
                        break;
                    }
                }
            }
        }

        if(side == "left"){
            for(int i = 0; i < list.size(); ++i) {

                Border border = (Border) list.get(i);

                double distance = Math.sqrt(Math.pow(enemy.x - border.getX(), 2) + Math.pow(enemy.y - border.getY(), 2));

                String type = border.getClass().toString().split(" ")[1].substring(18);
                String need_1 = "BorderV";
                String need_2 = "BorderVT";
                if (distance < enemy.dy/2 && ( type.equals(need_1)|| type.equals(need_2) ) ) {
                    if (enemy.x - enemy.dx < border.getX()) {
                        Coll = false;
                        break;
                    }
                }
            }
        }

        if(side == "right"){
            for(int i = 0; i < list.size(); ++i) {

                Border border = (Border) list.get(i);

                double distance = Math.sqrt(Math.pow((enemy.x + 70) - border.getX(), 2) + Math.pow(enemy.y - border.getY(), 2));

                String type = border.getClass().toString().split(" ")[1].substring(18);
                String need_1 = "BorderV";
                String need_2 = "BorderVT";
                if (distance < enemy.dy/2 && ( type.equals(need_1)|| type.equals(need_2) ) ) {
                    if (enemy.x + enemy.dx > border.getX()) {
                        Coll = false;
                        break;
                    }
                }
            }
        }

        return Coll;
    }




}

