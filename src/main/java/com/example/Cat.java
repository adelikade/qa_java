package com.example;

import java.util.List;

public class Cat {

    Predator predator;
    String catSound = "Мяу";

    public Cat(Feline feline) {
        this.predator = feline;
    }

    public String getSound() {
        return catSound;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
