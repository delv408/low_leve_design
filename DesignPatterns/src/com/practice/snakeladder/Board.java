package com.practice.snakeladder;

import java.util.ArrayList;

public class Board {
    private int size;

    private ArrayList<Link> ladders;

    private ArrayList<Link> snakes;

    public Board(int size){
        this.size = size;
    }

    public Board(int size, ArrayList<Link> ladders, ArrayList<Link> snakes){
        this.size = size;
        this.ladders = ladders;
        this.snakes = snakes;
    }

    public ArrayList<Link> getLadders() {
        return ladders;
    }

    public void setLadders(ArrayList<Link> ladders) {
        this.ladders = ladders;
    }

    public ArrayList<Link> getSnakes() {
        return snakes;
    }

    public void setSnakes(ArrayList<Link> snakes) {
        this.snakes = snakes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int isSnake(int pos){
        if(pos > size || pos < 1){
            System.out.println("Invalid position");
            return -1;
        }
        else {
            for (Link link : snakes) {
                if (pos == link.getStart()) {
                    return link.getEnd();
                }
            }
            return 0;
        }
    }

    public int isLadder(int pos){
        if(pos > size || pos < 1){
            System.out.println("Invalid position");
            return -1;
        }
        else {
            for (Link link : ladders) {
                if (pos == link.getStart()) {
                    return link.getEnd();
                }
            }
            return 0;
        }
    }
}
