package it.secondary.enumerators;

public enum WarriorType {
    CanePugnale("CanePugnale",1),
    CappelloDiPaglia("CappelloDiPaglia",2),
    ScimmiaRossa("ScimmiaRossa",3);

    private String type;
    private int code;

    WarriorType(String type, int code) {
        this.type = type;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public int getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(int code) {
        this.code = code;
    }


}


