package com.diarrmoh.Model.Character.Colossus;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Enumeration.Element;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.LinkedList;

public class RockGolem extends Colossus {

    protected static Image iconImage;

    protected static Image[] idleImage;

    protected static Image[] walkImage;

    protected static Image[][] jumpImage;

    protected static Image[] deathImage;

    protected static Image[][] attackImage;

    public RockGolem(String name, ImageView imageView, LinkedList<ImageView> projectileImageView, int playerNum, boolean selected) {
        super(name, imageView, projectileImageView, playerNum, selected);

        setDamage(30);

        setElement(Element.EARTH);
    }

    public static void loadImage() {
        System.out.println("Chargement");
        idleImage = new Image[4];
        for (int i= 0; i < idleImage.length; i++){
            idleImage[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/idle/Fichier_" + (i+1) + ".png")));
        }

        if (true){
            System.out.println("Chargement");
            walkImage = new Image[11];
            for (int i= 0; i < walkImage.length; i++){
                walkImage[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/walk/Fichier_" + (i+1) + ".png")));
            }

            jumpImage = new Image[0][0];

            attackImage = new Image[1][];

            System.out.println("Chargement");
            attackImage[0] = new Image[7];
            for (int i= 0; i < attackImage[0].length; i++){
                attackImage[0][i] = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/attack1/Fichier_" + (i+1) + ".png")));
            }

            System.out.println("Chargement");
            deathImage = new Image[6];
            for (int i= 0; i < deathImage.length; i++){
                deathImage[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/death/Fichier_" + (i+1) + ".png")));
            }

            System.out.println("Chargement");
            iconImage = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/icon.png")));
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
