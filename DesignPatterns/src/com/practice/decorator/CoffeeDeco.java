package com.practice.decorator;

public abstract class CoffeeDeco extends Beverage{

    private Beverage baseCoffee;

    public Beverage getBaseCoffee() {
        return baseCoffee;
    }

    public void setBaseCoffee(Beverage baseCoffee) {
        this.baseCoffee = baseCoffee;
    }
}
