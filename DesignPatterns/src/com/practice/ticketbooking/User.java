package com.practice.ticketbooking;

import java.util.ArrayList;

public class User {

    private String name;
    private BookingSession session;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BookingSession getSession() {
        return session;
    }

    public void setSession(BookingSession session) {
        this.session = session;
    }

    public boolean selectSeats(int numberOfSeats, Show show){
        return show.isAvailable(numberOfSeats);
    }

    public boolean selectSeats(ArrayList<Integer> seatNums, Show show){
        if (show.isAvailable(seatNums)) {
            show.markBlocked(seatNums);
            System.out.println("Blocked seats available");
            session = new BookingSession(seatNums, show);
            return true;
        }
        else{
            System.out.println("Requested Seats not available");
            return false;
        }
    }

    public void closeSession(){
        session.close();
        session = null;
    }
}
