package com.practice.ticketbooking;

import java.util.ArrayList;

public class Screen {

    private String type;
    private int screenNumber;
    private int capacity;
    private ArrayList<Show> shows;

    public Screen(int capacity) {
        this.capacity = capacity;
    }

    public void addShow(Show show){
        // add logic to check clashing show
        shows.add(show);
    }

    public void removeShow(Show show){
        shows.remove(show);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }
}
