package com.practice.decorator;

public abstract class Beverage {

    private String description;

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public abstract double getCost();
}
