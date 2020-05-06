package com.diarrmoh.Model.Engine.Enumeration;

public enum Origin {

    GARDEN("GARDEN"),
    COLOSSUS("COLOSSUS"),
    SORCERER("SORCERER");


    private String Name;

    Origin(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
