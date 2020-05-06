package com.diarrmoh.Model.game;

import com.diarrmoh.Model.Character.Characters;
import com.diarrmoh.Model.Character.Garden.Archer;
import com.diarrmoh.Model.Engine.Enumeration.AnimationEnum;
import com.diarrmoh.Model.Engine.Enumeration.Orientation;
import com.diarrmoh.Model.Engine.Projectile;
import javafx.scene.image.ImageView;

public class Renderer {

    private int jumpingRate;

    private ImageView projectileImageView;

    private Characters characters;

    private Projectile projectile;

    private int attack1Rate;

    private int idleRate;

    private int walkRate;

    private int jumpRate;

    private int deathRate;

    private int projectileRate;

    private long rate;
    private int touvhdownRate;

    public Renderer(Characters characters, Projectile projectile) {

        this.characters = characters;

        this.projectile = projectile;

        attack1Rate = 0;

        idleRate = 0;

        walkRate = 0;

        jumpRate = 0;

        deathRate = 0;

        projectileRate = 0;

        touvhdownRate = 0;

        jumpingRate = 0;

    }

    public void init() throws Exception {        
    }

    public void clear() {}

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public void Update() {
        if (projectile == null){
            if (characters.getImageView() != null) {
                if (characters.getAnimationState().equals(AnimationEnum.IDLE)) {
                    if (rate % (40/characters.getIdleImage().length) == 0){
                        idleRate %= characters.getIdleImage().length;
                        if (characters.getImageView() != null) characters.getImageView().setImage(characters.getIdleImage()[idleRate]);
                        idleRate++;
                    }
                }
                else if (characters.getAnimationState().equals(AnimationEnum.WALK_LEFT) || characters.getAnimationState().equals(AnimationEnum.WALK_RIGHT)) {
                    if (rate % (40/characters.getWalkImage().length) == 0){
                        walkRate %= characters.getWalkImage().length;
                        if (characters.getAnimationState().equals(AnimationEnum.WALK_LEFT) && characters.getOrientation().equals(Orientation.LEFT_TO_RIGHT)) {
                            characters.getImageView().setRotate(180);
                            characters.setOrientation(Orientation.RIGHT_TO_LEFT);
                        }
                        if (characters.getAnimationState().equals(AnimationEnum.WALK_RIGHT) && characters.getOrientation().equals(Orientation.RIGHT_TO_LEFT)) {
                            characters.getImageView().setRotate(0);
                            characters.setOrientation(Orientation.LEFT_TO_RIGHT);
                        }
                        if (characters.getImageView() != null) characters.getImageView().setImage(characters.getWalkImage()[walkRate]);
                        walkRate++;
                    }

                }
                else if (characters.getAnimationState().equals(AnimationEnum.TOUCHDOWN)) {
                    if (rate % 40/characters.getJumpImage()[2].length == 0){
                        touvhdownRate %= characters.getJumpImage()[2].length;
                        if (characters.getImageView() != null) characters.getImageView().setImage(characters.getJumpImage()[2][touvhdownRate]);
                        touvhdownRate++;
                    }
                }
                else if (characters.getAnimationState().equals(AnimationEnum.JUMPING)) {
                    if (rate % 40/characters.getJumpImage()[0].length == 0){
                        jumpingRate %= characters.getJumpImage()[0].length;
                        if (characters.getImageView() != null) characters.getImageView().setImage(characters.getJumpImage()[0][jumpingRate]);
                        jumpingRate++;
                    }
                }
                else if (characters.getAnimationState().equals(AnimationEnum.ATTACK1)) {
                    if (rate % (characters.getAttackImage()[0].length + 30/characters.getSpeed()+characters.getAttackImage()[0].length) == 0){
                        if (characters.getImageView() != null) characters.getImageView().setImage(characters.getAttackImage()[0][attack1Rate]);
                        attack1Rate++;
                        attack1Rate %= characters.getAttackImage()[0].length;
                        if (attack1Rate == 0) {
                            characters.setInAttack(false);
                            characters.setAnimationState(AnimationEnum.IDLE);
                            characters.attack();
                        }
                    }
                } else if (characters.getAnimationState().equals(AnimationEnum.DEATH)) {
                    if (rate % 20 == 0){

                        if (characters.getImageView() != null) characters.getImageView().setImage(characters.getDeathImage()[deathRate]);
                        deathRate++;
                        deathRate %= characters.getDeathImage().length;
                        if (deathRate == 0) {
                            characters.setIsDying(false);
                            characters.setAnimationState(AnimationEnum.IDLE);
                            characters.setHealthPoint(characters.getMaxHealth());
                        }
                    }
                }
            }

        } else {
            if (rate%5 == 0){
                projectileRate %= projectile.getCurrentProjectileImage().length;
                if (projectile.getProjectileImageView() != null) projectile.getProjectileImageView().setImage(projectile.getCurrentProjectileImage()[projectileRate]);
                projectileRate++;
            }
        }
        rate++;
    }

    public int getJumpingRate() {
        return jumpingRate;
    }

    public void setJumpingRate(int jumpingRate) {
        this.jumpingRate = jumpingRate;
    }

    public ImageView getProjectileImageView() {
        return projectileImageView;
    }

    public void setProjectileImageView(ImageView projectileImageView) {
        this.projectileImageView = projectileImageView;
    }

    public int getIdleRate() {
        return idleRate;
    }

    public void setIdleRate(int idleRate) {
        this.idleRate = idleRate;
    }

    public int getWalkRate() {
        return walkRate;
    }

    public void setWalkRate(int walkRate) {
        this.walkRate = walkRate;
    }

    public int getJumpRate() {
        return jumpRate;
    }

    public void setJumpRate(int jumpRate) {
        this.jumpRate = jumpRate;
    }

    public int getDeathRate() {
        return deathRate;
    }

    public void setDeathRate(int deathRate) {
        this.deathRate = deathRate;
    }

    public int getProjectileRate() {
        return projectileRate;
    }

    public void setProjectileRate(int projectileRate) {
        this.projectileRate = projectileRate;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public int getTouvhdownRate() {
        return touvhdownRate;
    }

    public void setTouvhdownRate(int touvhdownRate) {
        this.touvhdownRate = touvhdownRate;
    }
}
