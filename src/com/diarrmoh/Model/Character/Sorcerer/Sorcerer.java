package com.diarrmoh.Model.Character.Sorcerer;

import com.diarrmoh.Model.Character.Character;
import com.diarrmoh.Model.Engine.Enumeration.Origin;
import javafx.scene.image.ImageView;

import java.util.LinkedList;

public abstract class Sorcerer extends Character {

    public Sorcerer(String name, ImageView imageView, LinkedList<ImageView> projectileImageView, int playerNum, boolean selected) {
        super(name, imageView, projectileImageView, playerNum, selected);

        setMaxHealth(400);
        setHealthPoint(getMaxHealth());

        setOrigin(Origin.SORCERER);
    }
}