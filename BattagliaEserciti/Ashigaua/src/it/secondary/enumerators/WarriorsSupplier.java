package it.secondary.enumerators;

import it.secondary.warriorTemplate.Warrior;

import java.util.function.Supplier;

public class WarriorsSupplier implements Supplier<Warrior> {

    @Override
    public Warrior get(){
        return new Warrior();
    }
}
