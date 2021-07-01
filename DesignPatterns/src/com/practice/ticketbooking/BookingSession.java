package com.practice.ticketbooking;

import java.time.*;

import java.sql.Time;
import java.time.Instant;
import java.util.ArrayList;

public class BookingSession {

    private long startTime;
    private ArrayList<Integer> seatsSelected;
    private Show show;

    private final int TIME_OUT = 90; //in seconds

    private Booking booking;

    public BookingSession(ArrayList<Integer> seatsSelected, Show show) {

        this.startTime = getCurrentEpochSec();
        this.seatsSelected = seatsSelected;
        this.show = show;
    }

    public BookingSession(ArrayList<Integer> seatsSelected, Booking booking, Show show) {
        this.seatsSelected = seatsSelected;
        this.booking = booking;
        this.show = show;
    }

    public void close(){
        show.markVacant(seatsSelected);
    }

    private long getCurrentEpochSec(){
        Instant instant
                = Instant.now();
        return instant.getEpochSecond();
    }

    private boolean isTimedOut(){
        boolean state = getCurrentEpochSec() - startTime > TIME_OUT;
        if(state){
            System.out.println("Session Timed out");
        }
        return state;
    }

    public void proceedToPay(){


        if (isTimedOut()){
            show.markVacant(seatsSelected);

            return;
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        booking = new Booking(seatsSelected);
        if(booking.payment.pay()){

            show.markBooked(seatsSelected);
            System.out.println("Payment Successful");

        }
        else{
            System.out.println("Payment Failed. Wanna retry?");
            show.markVacant(seatsSelected);
        }

    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public ArrayList<Integer> getSeatsSelected() {
        return seatsSelected;
    }

    public void setSeatsSelected(ArrayList<Integer> seatsSelected) {
        this.seatsSelected = seatsSelected;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
