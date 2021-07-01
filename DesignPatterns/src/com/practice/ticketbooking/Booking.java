package com.practice.ticketbooking;

import java.util.ArrayList;

public class Booking {

    private int numSeats;
    private ArrayList<Integer> seatNums;

    public Payment payment;

    private String screenNumber;
    private String theatreName;
    private String showId;

    public Booking(ArrayList<Integer> seatNums) {
        this.numSeats = seatNums.size();
        this.seatNums = seatNums;
        this.payment = new Payment(100*this.numSeats);
    }
}
