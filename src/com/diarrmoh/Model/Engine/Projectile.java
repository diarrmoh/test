package com.diarrmoh.Model.Engine;


import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Character.Characters;
import com.diarrmoh.Model.Character.Colossus.RockGolem;
import com.diarrmoh.Model.Character.Garden.Archer;
import com.diarrmoh.Model.Engine.Enumeration.Orientation;
import com.diarrmoh.Model.Engine.Physics.Physics;
import com.diarrmoh.Model.game.ForestFightQuest;
import com.diarrmoh.Model.game.Renderer;
import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Projectile {

    private ImageView projectileImageView;

    private static Image[][] projectileImages;

    private Image[] currentProjectileImage;

    private Characters characters;

    private Renderer renderer;

    private Physics physics;

    private Orientation orientation;

    public Projectile(ImageView projectileImageView, Characters characters) {
        this.projectileImageView = projectileImageView;
        this.characters = characters;
        this.orientation = this.characters.getOrientation();
        if (orientation.equals(Orientation.RIGHT_TO_LEFT)){
            projectileImageView.setRotationAxis(new Point3D(0,1,0));
            projectileImageView.setRotate(180);
        }
        this.renderer = new Renderer(null, this);
        this.physics = new Physics(null, this);
        this.projectileImageView.setX(characters.getImageView().getX());
        this.projectileImageView.setY(characters.getImageView().getY() + characters.getImageView().getFitHeight()/2);
        if (this.characters.getClass().equals(Archer.class)) setCurrentProjectileImage(getProjectileImages()[0]);
        else if (this.characters.getClass().equals(RockGolem.class)) setCurrentProjectileImage(getProjectileImages()[1]);
        else setCurrentProjectileImage(getProjectileImages()[2]);
    }


    public static void load() {
        projectileImages = new Image[3][];

        System.out.println("Chargement");
        projectileImages[0] = new Image[1];
        for (int i= 0; i < projectileImages[0].length; i++){
            projectileImages[0][i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/projectile/Fichier_" + (i+1) + ".png")));
        }

        System.out.println("Chargement");
        projectileImages[1] = new Image[7];
        for (int i= 0; i < projectileImages[1].length; i++){
            projectileImages[1][i] = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/projectile/Fichier_" + (i+1) + ".png")));
        }

        System.out.println("Chargement");
        projectileImages[2] = new Image[3];
        for (int i= 0; i < projectileImages[2].length; i++){
            projectileImages[2][i] = new Image(String.valueOf(Launcher.class.getResource("Data/Wizard/projectile/Fichier_" + (i+1) + ".png")));
        }
    }

    public void destroy(){
        setCharacters(null);
        setPhysics(null);
        setRenderer(null);
        getProjectileImageView().setImage(null);
        for (int i = 0; i < ForestFightQuest.projectiles.size(); i++) {
            if (ForestFightQuest.projectiles.get(i).equals(this)){
                ForestFightQuest.projectiles.remove(i);
                return;
            }
        }
    }

    public static Image[][] getProjectileImages() {
        return projectileImages;
    }

    public static void setProjectileImages(Image[][] projectileImages) {
        Projectile.projectileImages = projectileImages;
    }

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public ImageView getProjectileImageView() {
        return projectileImageView;
    }

    public void setProjectileImageView(ImageView projectileImageView) {
        this.projectileImageView = projectileImageView;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public Physics getPhysics() {
        return physics;
    }

    public void setPhysics(Physics physics) {
        this.physics = physics;
    }

    public boolean mustBeDestroyed() {
        if (projectileImageView.getX() > 1920 || projectileImageView.getX() + projectileImageView.getFitWidth() < 0) return true;

        return false;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Image[] getCurrentProjectileImage() {
        return currentProjectileImage;
    }

    public void setCurrentProjectileImage(Image[] currentProjectileImage) {
        this.currentProjectileImage = currentProjectileImage;
    }
}
