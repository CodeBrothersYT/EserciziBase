package it.secondary.warriorTemplate;

import it.secondary.enumerators.WarriorType;
import it.secondary.enumerators.WarriorsSupplier;
import it.secondary.enumerators.WeaponType;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Warrior {

    public static final Random random = new Random();
    private double healthPoints = 100f;
    private WarriorType type;
    private WeaponType weapon;
    private int basicDamage = random.nextInt(4)+1;
    private boolean alive = true;


    public Warrior() {
        this.type = getRandomWarriorType();
        this.weapon = getRandomWarriorWeapon();
    }



    private WarriorType getRandomWarriorType(){
        WarriorType[] warriorTypes = WarriorType.values();
        return warriorTypes[random.nextInt(warriorTypes.length)];
    }

    private WeaponType getRandomWarriorWeapon() {
        final WeaponType[] weapons = WeaponType.values();
        return weapons[random.nextInt(weapons.length)];
    }


    public static List<Warrior> getArmy(){
        //al posto di new WarriorsSupplier() potevo scrivere semplicemente () -> new Warrior() perchè
        //il mio generate vuole un Supplier<T> s, e a sua volta il Supplier ha dentro solamente T get();
        //quindi visto che il get non prende niente all'inizio della lambda scrivi "()" e il return type che
        //è la freccia -> avrà il new Warrior() che infatti avevo nella classe WarriorsSupplier.
        //In verità comunque la freccia indica solamente l'inizio del corpo della lambda. Rileggi in caso
        return Stream.generate(new WarriorsSupplier()).limit(5).collect(Collectors.toList());
    }



    @Override
    public String toString() {
        return "Warrior{" +
                "strength=" + healthPoints +
                ", type=" + type +
                ", weapon=" + weapon.toString() +
                ", ability=" + basicDamage +
                '}';
    }

    public double getHealthPoints(){
        return healthPoints < 0 ? 0 : healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public WarriorType getType() {
        return type;
    }

    public void setType(WarriorType type) {
        this.type = type;
    }

    public WeaponType getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponType weapon) {
        this.weapon = weapon;
    }

    public int getBasicDamage() {
        return basicDamage;
    }

    public void setBasicDamage(int basicDamage) {
        this.basicDamage = basicDamage;
    }

    public boolean getAlive(){
        return this.alive;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }
}
