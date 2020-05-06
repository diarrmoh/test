package com.diarrmoh.Model.Character.Colossus;

import com.diarrmoh.Model.Character.Character;
import com.diarrmoh.Model.Engine.Enumeration.Origin;
import javafx.scene.image.ImageView;

import java.util.LinkedList;

public abstract class Colossus extends Character {

    public Colossus(String name, ImageView imageView, LinkedList<ImageView> projectileImageView, int playerNum, boolean selected) {
        super(name, imageView, projectileImageView, playerNum, selected);

        setMaxHealth(1000);
        setHealthPoint(getMaxHealth());

        setOrigin(Origin.COLOSSUS);
    }
}
