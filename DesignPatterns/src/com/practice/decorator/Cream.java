package com.practice.decorator;

public class Cream extends CoffeeDeco{

    public Cream(Beverage base){
        setBaseCoffee(base);
        setDescription("Creame " + base.getDescription());
    }
    @Override
    public double getCost() {
        return 0.16 + this.getBaseCoffee().getCost();
    }

}
