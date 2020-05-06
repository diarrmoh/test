package com.diarrmoh.Model.Character.Garden;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Engine;
import com.diarrmoh.Model.Engine.Enumeration.Element;
import com.diarrmoh.Model.Engine.Projectile;
import com.diarrmoh.Model.game.ForestFightQuest;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;

public class Archer extends Garden {

    protected static Image iconImage;

    protected static Image[] idleImage;

    protected static Image[] walkImage;

    protected static Image[][] jumpImage;

    protected static Image[] deathImage;

    protected static Image[][] attackImage;

    public Archer(String name, ImageView imageView, LinkedList<ImageView> projectileImageView, int playerNum, boolean selected) {
        super(name, imageView, projectileImageView, playerNum, selected);

        setDamage(50);

        setElement(Element.AIR);
    }

    public static void loadImage() {
        System.out.println("Chargement");
        idleImage = new Image[6];
        for (int i= 0; i < idleImage.length; i++){
            idleImage[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/idle/Fichier_" + (i+1) + ".png")));
        }

        if (true){
            System.out.println("Chargement");
            walkImage = new Image[14];
            for (int i= 0; i < walkImage.length; i++){
                walkImage[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/walk/Fichier_" + (i+1) + ".png")));
            }

            jumpImage = new Image[3][];

            System.out.println("Chargement");
            jumpImage[0] = new Image[3];
            for (int i= 0; i < jumpImage[0].length; i++){
                jumpImage[0][i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/jump/jumping/Fichier_" + (i+1) + ".png")));
            }

            System.out.println("Chargement");
            jumpImage[1] = new Image[2];
            for (int i= 0; i < jumpImage[1].length; i++){
                jumpImage[1][i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/jump/inair/Fichier_" + (i+1) + ".png")));
            }

            System.out.println("Chargement");
            jumpImage[2] = new Image[3];
            for (int i= 0; i < jumpImage[2].length; i++){
                jumpImage[2][i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/jump/touchdown/Fichier_" + (i+1) + ".png")));
            }

            attackImage = new Image[2][];

            System.out.println("Chargement");
            attackImage[0] = new Image[6];
            for (int i= 0; i < attackImage[0].length; i++){
                attackImage[0][i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/attack1/Fichier_" + (i+1) + ".png")));
            }

            System.out.println("Chargement");
            attackImage[1] = new Image[6];
            for (int i= 0; i < attackImage[1].length; i++){
                attackImage[1][i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/attack2/Fichier_" + (i+1) + ".png")));
            }

            System.out.println("Chargement");
            deathImage = new Image[6];
            for (int i= 0; i < deathImage.length; i++){
                deathImage[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/death/Fichier_" + (i+1) + ".png")));
            }

            System.out.println("Chargement");
            iconImage = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/icon.png")));
        }
    }

    @Override
    public Image[] getWalkImage() {
        return walkImage;
    }

    @Override
    public void setWalkImage(Image[] walkImage) {
        this.walkImage = walkImage;
    }

    @Override
    public Image[][] getJumpImage() {
        return jumpImage;
    }

    @Override
    public void setJumpImage(Image[][] jumpImage) {
        this.jumpImage = jumpImage;
    }

    @Override
    public Image[] getDeathImage() {
        return deathImage;
    }

    @Override
    public void setDeathImage(Image[] deathImage) {
        this.deathImage = deathImage;
    }

    @Override
    public Image[][] getAttackImage() {
        return attackImage;
    }

    @Override
    public void setAttackImage(Image[][] attackImage) {
        this.attackImage = attackImage;
    }

    @Override
    public Image[] getIdleImage(){
        return idleImage;
    }

    @Override
    public void setIdleImage(Image[] idleImage){
        this.idleImage = idleImage;
    }

    @Override
    public Image getIconImage() {
        return iconImage;
    }

    @Override
    public void setIconImage(Image iconImage) {
        this.iconImage = iconImage;
    }
}
