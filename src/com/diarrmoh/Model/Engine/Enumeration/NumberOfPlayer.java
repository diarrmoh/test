package com.diarrmoh.Model.Engine.Enumeration;

public enum NumberOfPlayer {
    OnePlayer(1,"One Player"),
    TwoPlayer(2,"Two Player"),
    FourPlayer(4,"Four Player");
    private int numberOfPlayer;
    private String name;

    NumberOfPlayer(int numberOfPlayer, String name) {
        this.numberOfPlayer = numberOfPlayer;
        this.name = name;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
