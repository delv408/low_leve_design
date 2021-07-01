package com.practice.ticketbooking;

import java.util.ArrayList;
import java.util.Collections;

public class Show {

    private String id;
    private Movie movie; // should be made generic
    private int duration;
    private int startTime;

    private ArrayList<Integer> seatAvailability; // should use type for this ??

    public Show(Movie movie, int duration, int startTime, int numSeats) {
        this.movie = movie;
        this.duration = duration;
        this.startTime = startTime;
        this.seatAvailability = new ArrayList<Integer>(Collections.nCopies(numSeats, 0));
    }

    public Show(Movie movie, int duration, int startTime, ArrayList<Integer> seatAvailability) {
        this.movie = movie;
        this.duration = duration;
        this.startTime = startTime;
        this.seatAvailability = seatAvailability;
    }

    public ArrayList<Integer> showSeats(){
        return seatAvailability;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public ArrayList<Integer> getAvailableSeats(){
        ArrayList<Integer> availableSeats = new ArrayList<>();
        for (int counter = 0; counter < seatAvailability.size(); counter++) {
            if(seatAvailability.get(counter) == 0){
                availableSeats.add(counter);
                System.out.print(counter + " ");
            }
        }
        System.out.print('\n');

        return availableSeats;
    }

    public boolean isAvailable(int numOfSeats){
        return getAvailableSeats().size() >= numOfSeats;

    }

    public boolean isAvailable(ArrayList<Integer> seatNums){
        for (Integer seatNumber : seatNums) {
            if(seatNumber < seatAvailability.size() && seatAvailability.get(seatNumber) != 0){
                return false;
            }
        }
        return true;
    }

    private boolean markSeats(ArrayList<Integer> seatNums, Integer mark){
        for (Integer seatNumber : seatNums) {
            if(seatNumber < seatAvailability.size()){
                seatAvailability.set(seatNumber, mark);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public boolean markBlocked(ArrayList<Integer> seatNums){
        return  markSeats(seatNums, 1);
    }

    public boolean markBooked(ArrayList<Integer> seatNums){
        return  markSeats(seatNums, 2);
    }

    public boolean markVacant(ArrayList<Integer> seatNums){
        return  markSeats(seatNums, 0);
    }

}
