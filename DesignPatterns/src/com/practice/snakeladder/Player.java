package com.practice.snakeladder;

public class Player {
    public Goti goti;
    public String name;

    // won


    public Player(Goti goti, String name){
        this.goti = goti;
        this.name = name;
    }

    public Goti getGoti() {
        return goti;
    }

    public void setGoti(Goti goti) {
        this.goti = goti;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void moveGoti(int position){
        goti.position = position;
        System.out.println(String.format("Player: %s moved to %d", name, goti.position));
    }

    public void moveGotiBy(int places){
        goti.position += places;
        System.out.println(String.format("Player: %s moved to %d", name, goti.position));
    }
    // todo move by this many places
    //  and check final postion for
    //  snake or ladder
}
