package com.diarrmoh.Model.Engine.Enumeration;

public enum Element {
    EARTH("EARTH"),
    WATER("WATER"),
    AIR("AIR"),
    FIRE("Fire");


    private String Name;

    Element(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
