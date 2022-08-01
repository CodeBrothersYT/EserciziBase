package it.secondary.enumerators;

public enum VictoryMessage {
    YEAH1("OH YEAH!"),
    YEAH2("GRANDEEEEE"),
    YEAH3("WHOOO INCREDIBILE"),
    YEAH4("NON CI CREDO PAZZESCO"),
    YEAH5("TROPPO TROPPOOOO ASSURDO"),
    YEAH6("OMGGGG");

    String type;

    VictoryMessage(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
