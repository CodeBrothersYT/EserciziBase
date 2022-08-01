package it.secondary.enumerators;

public enum Curse {

    CASPITA("CASPITA"),
    NOOOOOOO("NOOOOO DAI"),
    AIUTOOOO("AIUTOOOOOOO"),
    MA("MA HAI VISTO?!"),
    E("E ADESSO???"),
    SKRT("SKRT!");

    private final String type;

    Curse(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
