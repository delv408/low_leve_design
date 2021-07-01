package com.practice.decorator;

public class Mocha extends CoffeeDeco{

    public Mocha(Beverage base){
        setBaseCoffee(base);
        setDescription("Mocha " + base.getDescription());
    }
    @Override
    public double getCost() {
        return 0.53 + this.getBaseCoffee().getCost();
    }

}
