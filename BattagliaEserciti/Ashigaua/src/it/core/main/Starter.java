package it.core.main;

import it.secondary.Battle.Battle;
import it.secondary.warriorTemplate.Warrior;

import java.util.List;

import static it.secondary.warriorTemplate.Warrior.getArmy;


public class Starter {

    public static void main(String[] args) throws InterruptedException {
        List<Warrior> firstArmy = getArmy();
        List<Warrior> secondArmy = getArmy();
        Battle battle = new Battle(firstArmy,secondArmy);
        battle.start();
    }
}
