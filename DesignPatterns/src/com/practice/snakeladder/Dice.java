package com.practice.snakeladder;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private String color;

    private int faces;

    public Dice(int size){
        this.faces = size;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(int size) {
        this.faces = size;
    }

    public int diceThrow(){

        int randomNum = ThreadLocalRandom.current().nextInt(1, faces + 1);
        System.out.println(String.format("Dice rolled :: %d", randomNum));
        return randomNum;
    }
}
