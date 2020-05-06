package com.diarrmoh.Model.Engine.Physics;


import com.diarrmoh.Model.Character.Characters;
import com.diarrmoh.Model.Engine.Collision;
import com.diarrmoh.Model.Engine.Enumeration.AnimationEnum;
import com.diarrmoh.Model.Engine.Enumeration.Orientation;
import com.diarrmoh.Model.Engine.Platforms;
import com.diarrmoh.Model.Engine.Projectile;
import com.diarrmoh.Model.game.ForestFightQuest;
import javafx.application.Platform;

import static com.diarrmoh.Model.Engine.Collision.isCollision;

public class Physics {

    private Point point;

    private Characters characters;

    private Projectile projectile;

    private int jumpHeigh;

    public Physics(Characters characters, Projectile projectile) {
        point = new Point(0,0);
        this.characters = characters;
        this.projectile = projectile;
        this.jumpHeigh = 0;
    }

    public void Update() {
        if (projectile == null){
            if (characters.isSelected()){
                if (characters.isJumping()){
                    moveY(point.getY() - 10);
                    jumpHeigh++;
                    physix();
                } else {
                    if (characters.getImageView() != null){
                        if (characters.getAnimationState().equals(AnimationEnum.IDLE)){

                        } else if (characters.getAnimationState().equals(AnimationEnum.WALK_LEFT)){
                            moveX(point.getX() - characters.getSpeed());
                        } else if (characters.getAnimationState().equals(AnimationEnum.WALK_RIGHT)){
                            moveX(point.getX() + characters.getSpeed());
                        } else if (characters.getAnimationState().equals(AnimationEnum.JUMPING)){

                        }  else if (characters.getAnimationState().equals(AnimationEnum.ATTACK1)){

                        }  else if (characters.getAnimationState().equals(AnimationEnum.ULTIMEATACK)){

                        }  else if (characters.getAnimationState().equals(AnimationEnum.DEATH)){

                        }
                        physix();
                    }
                }
            }
        } else {
            if (projectile.getOrientation().equals(Orientation.LEFT_TO_RIGHT))projectile.getProjectileImageView().setX(projectile.getProjectileImageView().getX() + 20);
            else projectile.getProjectileImageView().setX(projectile.getProjectileImageView().getX() - 20);
            if (projectile.mustBeDestroyed()) projectile.destroy();
        }

    }

    public void moveY(double v) {
        getPoint().setY(v);
        getCharacters().getImageView().setY(getPoint().getY());
    }

    private void physix() {
        if (jumpHeigh > 20){
            jumpHeigh = 0;
            characters.setJumping(false);
        }
        if (point.getY() < 730 && !isPlateformCollision() && !characters.getAnimationState().equals(AnimationEnum.JUMPING)){
            if (characters.canJump()) characters.setAnimationState(AnimationEnum.TOUCHDOWN);
            moveY(point.getY() + 10);
            if (point.getY() >= 730 || isPlateformCollision()){
                characters.setSpeed(10);
                characters.setAnimationState(AnimationEnum.IDLE);
                characters.setJumping(false);
            }
        }
        double damage = targetReached();
        if (damage != 0) characters.setHealthPoint(characters.getHealthPoint() - damage);
    }

    private double targetReached() {
        double damage = 0;
        for (int i = 0; i < ForestFightQuest.projectiles.size(); i++) {
            if (Collision.isCollision(ForestFightQuest.projectiles.get(i), characters)){
                if (!ForestFightQuest.projectiles.get(i).getCharacters().equals(characters)){
                    damage = ForestFightQuest.projectiles.get(i).getCharacters().getDamage();
                    ForestFightQuest.projectiles.get(i).destroy();
                }
            }
        }

        return damage;
    }

    public void moveX(double v) {
        point.setX(v);
        characters.getImageView().setX(point.getX());
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    private boolean isPlateformCollision(){
        for (Platforms plat : Platforms.platforms){
            if (isCollision(plat, characters)) return true;
        }
        return false;
    }


}
