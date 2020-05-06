package com.diarrmoh.Model.Engine;

import com.diarrmoh.Model.Character.Characters;

public class Collision {

    public static boolean isCollision(GameObject object, Characters characters){
        int delta = 0;
        if (object.equals(Platforms.class)) delta = 20;
        if (((object.getImageView().getX() < characters.getImageView().getX()) &&
                (object.getImageView().getX() + object.getImageView().getFitWidth() > characters.getImageView().getX() + characters.getImageView().getFitWidth())) &&
                    ((object.getImageView().getY() + delta < characters.getImageView().getY() + characters.getImageView().getFitHeight()) &&
                            (object.getImageView().getY() + object.getImageView().getFitHeight() > characters.getImageView().getY() + characters.getImageView().getFitHeight()))){
            return true;
        }

        return false;
    }

    public static boolean isCollision(Projectile projectile, Characters characters){
        if ((((characters.getImageView().getX() < projectile.getProjectileImageView().getX()) &&
                (characters.getImageView().getX() + characters.getImageView().getFitWidth()) > projectile.getProjectileImageView().getX()) ||
                ((characters.getImageView().getX() < projectile.getProjectileImageView().getX() + projectile.getProjectileImageView().getFitWidth()) &&
                        (characters.getImageView().getX() + characters.getImageView().getFitWidth()) > projectile.getProjectileImageView().getX() + projectile.getProjectileImageView().getFitWidth())) &&
                (((characters.getImageView().getY() < projectile.getProjectileImageView().getY()) &&
                        (characters.getImageView().getY() + characters.getImageView().getFitHeight()) > projectile.getProjectileImageView().getY()) ||
                        ((characters.getImageView().getY() < projectile.getProjectileImageView().getY() + projectile.getProjectileImageView().getFitHeight()) &&
                                (characters.getImageView().getY() + characters.getImageView().getFitHeight()) > projectile.getProjectileImageView().getY() + projectile.getProjectileImageView().getFitHeight()))){
            return true;
        }

        return false;
    }


}
