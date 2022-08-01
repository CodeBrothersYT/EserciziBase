package it.secondary.Battle;

import it.console.Console;
import it.secondary.enumerators.VictoryMessage;
import it.secondary.warriorTemplate.Warrior;
import it.secondary.enumerators.Curse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static it.secondary.warriorTemplate.Warrior.random;


public class Battle {

    private List<Warrior> firstArmy;
    private List<Warrior> secondArmy;

    public Battle(List<Warrior> firstArmy, List<Warrior> secondArmy) {
        this.firstArmy = firstArmy;
        this.secondArmy = secondArmy;
    }

    public void start() throws InterruptedException {
        System.out.println("dimmi il nome del tuo esercito: ");
        String armyName = Console.readString();
        int survivors = Math.min(firstArmy.size(), secondArmy.size());
        List<Warrior> survivorsFirst = new ArrayList<>();
        List<Warrior> survivorsSecond = new ArrayList<>();
        int counter = 0;
        while (survivors != 0) {
            for (int i = 0; i < survivors; i++) {

                Thread.sleep(250);
                System.out.println(".");
                Thread.sleep(1100);
                System.out.println(". .");
                Thread.sleep(1350);
                System.out.println(". . .");
                Thread.sleep(1720);

                Warrior first = firstArmy.get(i);
                Warrior second = secondArmy.get(i);
                System.out.println("~ ~ ~ Comincia la battaglia round n°: " + counter + " ~ ~ ~");
                fight(first,second);
                counter++;

                survivorsFirst =  firstArmy.stream()
                        .filter(Warrior::getAlive)
                        .collect(Collectors.toList());
                System.out.printf("I superstiti del tuo esercito: %s sono %s\n",armyName, survivorsFirst.size());
                firstArmy = survivorsFirst;


                survivorsSecond = secondArmy.stream()
                        .filter(Warrior::getAlive)
                        .collect(Collectors.toList());
                System.out.printf("I superstiti dell'esercito avversario sono: %s\n",survivorsSecond.size());
                secondArmy = survivorsSecond;
                survivors = Math.min(survivorsFirst.size(), survivorsSecond.size());
            }



            if (survivorsFirst.size() == 0) {
                System.out.println("Sei morto ¯\\_(ツ)_/¯");
            } else if (survivorsSecond.size() == 0) {
                System.out.println(
                        "⣿⣿⣿⣿⣿⡏⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠁⠀⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠙⠿⠿⠿⠻⠿⠿⠟⠿⠛⠉⠀⠀⠀⠀⠀⣸⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣴⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⢰⣹⡆⠀⠀⠀⠀⠀⠀⣭⣷⠀⠀⠀⠸⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠈⠉⠀⠀⠤⠄⠀⠀⠀⠉⠁⠀⠀⠀⠀⢿⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣿⢾⣿⣷⠀⠀⠀⠀⡠⠤⢄⠀⠀⠀⠠⣿⣿⣷⠀⢸⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣿⡀⠉⠀⠀⠀⠀⠀⢄⠀⢀⠀⠀⠀⠀⠉⠉⠁⠀⠀⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿\n" +
                                "\n"+
                        "HAI VINTO CAMPIONE! GRANDE!");
            }
        }


    }


    public void fight(Warrior first, Warrior second) throws InterruptedException {

        while (first.getAlive() && second.getAlive()) {
            double firstWarriorAtk = first.getBasicDamage() * random.nextFloat() * first.getWeapon().getAtk();
            double secondWarriorDef = random.nextFloat() * second.getWeapon().getDef();

            if (firstWarriorAtk > secondWarriorDef) {
                second.setHealthPoints(second.getHealthPoints() - firstWarriorAtk);
                    Thread.sleep(1000);

                System.out.printf("""
                    Il tuo guerriero: %s attacca con %s facendo un danno di %s e lasciando all'avversario %s: %s HP
                    """, first.getType(), first.getWeapon().getType(),twoDecimal(firstWarriorAtk),
                        second.getType(),twoDecimal(second.getHealthPoints()));

                    if(second.getHealthPoints() <= 0) {
                        System.out.println(getRandomVictory().getType() + " HAI UCCISO L'AVVERSARIO!\n");
                        second.setAlive(false);
                    }
            } else {
                first.setHealthPoints(first.getHealthPoints() - secondWarriorDef);
                if (first.getHealthPoints() > 0) {

                    Thread.sleep(1000);
                    System.out.println("L'avversario: " + second.getType() + " attacca con " + second.getWeapon().getType() + " con un danno di " + twoDecimal(secondWarriorDef) +
                            " lasciando al tuo " + first.getType() + ": " + twoDecimal(first.getHealthPoints()) + " HP");
                } else {
                    Thread.sleep(1000);
                    System.out.println(getRandomCurse().getType() + "SEI STATO UCCISO!\n");
                    first.setAlive(false);
                }
            }
        }
    }

    public VictoryMessage getRandomVictory() {
        VictoryMessage[] listOfVictoryMessage = VictoryMessage.values();
        return listOfVictoryMessage[random.nextInt(listOfVictoryMessage.length)];
    }

    public Curse getRandomCurse(){
        Curse[] listCurses = Curse.values();
        return listCurses[random.nextInt(listCurses.length)];
    }

    public static double twoDecimal(double input){
        BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
