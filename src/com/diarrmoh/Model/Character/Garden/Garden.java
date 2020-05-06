package com.diarrmoh.Model.Character.Garden;

import com.diarrmoh.Model.Character.Character;
import com.diarrmoh.Model.Engine.Enumeration.Origin;
import javafx.scene.image.ImageView;
import java.util.LinkedList;

public abstract class Garden extends Character{

    public Garden(String name, ImageView imageView, LinkedList<ImageView> projectileImageView, int playerNum, boolean selected) {
        super(name, imageView, projectileImageView, playerNum, selected);

        setMaxHealth(600);
        setHealthPoint(getMaxHealth());

        setOrigin(Origin.GARDEN);
    }
}

