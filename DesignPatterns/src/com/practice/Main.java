package com.practice;

import com.practice.snakeladder.*;
import com.practice.state.Canvas;
import com.practice.state.LineTool;
import com.practice.decorator.*;
import com.practice.ticketbooking.*;
import javafx.util.Pair;

import java.math.BigInteger;
import java.util.ArrayList;

import java.lang.Math.*;

public class Main {

    public void playSnakeLadder(){

        ArrayList<Link> ladders = new ArrayList<>();
        ladders.add(new Link(4,20));
        ladders.add(new Link(12,41));
        ladders.add(new Link(34,81));

        ArrayList<Link> snakes = new ArrayList<>();
        snakes.add(new Link(37,13));
        snakes.add(new Link(68,27));
        snakes.add(new Link(92,46));

        Board board = new Board(100, ladders, snakes);

        Dice dice = new Dice(6);
        Player p1 = new Player(new Goti(),"Anil");
        Player p2 = new Player(new Goti(),"Sachin");
        //  Info needed:
        //  Number of Players
        Game practice = new Game(board, dice, p1, p2);
        practice.play();
    }

    public void statePattern(){
        Canvas canvas = new Canvas();
        canvas.setCurrentTool(new LineTool());
        canvas.draw();
    }

    public void decoratorPattern(){

        Beverage base = new DarkRoast();
        Beverage withMocha = new Mocha(base);
        Beverage myCoffee = new Cream(withMocha);

        System.out.println(myCoffee.getCost());
        System.out.println(myCoffee.getDescription());
    }

    public static void ticketBooking(){
        Theatre t1 = new Theatre("PVR Priya");
        Screen s1 = new Screen(50);
        Movie m1 = new Movie("Radhe", 180);
        Show sh1 = new Show(m1, 200, 1500, s1.getCapacity());
        User u1 = new User("Sowmya");
        User u2 = new User("Anusha");

        ArrayList<Integer> seatsT1 = sh1.getAvailableSeats();
        u1.selectSeats( new ArrayList<Integer>(seatsT1.subList(0,5)), sh1);



        ArrayList<Integer> seatsT2 = sh1.getAvailableSeats();

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        u1.getSession().proceedToPay();

        sh1.getAvailableSeats();


    }



    public static int primeSteps(int val, int n, int limit)
    {
        int count =0;
        if(2 >= limit){
            return -1;
        }
        while (n!=1 && n%2==0)
        {
            n /= 2;
            count++;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(val)+1; i+= 2)
        {
            if(i >= limit){
                return -1;
            }
            // While i divides n, print i and divide n
            while (n!=1 && n%i == 0)
            {
                n /= i;
                count++;
            }
            if(n==1){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int x = 160;
        int y = 180;
        BigInteger x_big = BigInteger.valueOf(x);
        BigInteger y_big = BigInteger.valueOf(y);
        int m = 10;

        int floor = x_big.gcd(y_big).intValue();
        int x_factor = x/floor;
        int y_factor = y/floor;

        // find prime factors of x_factor
        int x_step, y_step, step;
        if(x_factor == 1){
            x_step = 0;
        }
        else{
            x_step  = primeSteps(x, x_factor, m);
        }

        if(y_factor == 1){
            y_step = 0;
        }
        else{
            y_step  = primeSteps(y, y_factor, m);
        }
        System.out.println(floor);

        if(x_step == -1 || y_step ==-1){
            step = -1;
        }
        else{
            step = x_step+y_step;
        }
        System.out.println(step);

    }
}
