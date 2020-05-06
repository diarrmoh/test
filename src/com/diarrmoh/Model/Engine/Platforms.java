package com.diarrmoh.Model.Engine;

import javafx.scene.image.ImageView;

import java.util.LinkedList;

public class Platforms implements GameObject {

    public static LinkedList<Platforms> platforms = new LinkedList<Platforms>();

    private ImageView imageView;

    public Platforms(ImageView imageView) {
        platforms.add(this);
        this.imageView = imageView;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
