package com.practice.ticketbooking;

import java.util.ArrayList;

public class Theatre {

    private String name;
    private String location;
    private String type; // again enum ??

    private ArrayList<Screen> screens;

    public Theatre(String name){
        this.name = name;
    }

    public Theatre(String name, ArrayList<Screen> screens) {
        this.name = name;
        this.screens = screens;
    }

    public ArrayList<Screen> getScreens() {
        return screens;
    }

    public void setScreens(ArrayList<Screen> screens) {
        this.screens = screens;
    }

    public void addScreen(Screen screen){
        screens.add(screen);
    }

    public void removeScreen(Screen screen){
        screens.remove(screen);
    }
}
