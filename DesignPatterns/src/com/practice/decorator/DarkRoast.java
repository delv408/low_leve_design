package com.practice.decorator;

public class DarkRoast extends Beverage{

    public DarkRoast(){
        setDescription("Dark... Very Dark");
    }
    @Override
    public double getCost() {
        return 0.99;
    }
}
