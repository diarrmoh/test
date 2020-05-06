package com.diarrmoh.Model.Character;

import com.diarrmoh.Model.Engine.Enumeration.Element;
import com.diarrmoh.Model.Engine.Enumeration.Origin;
import com.diarrmoh.Model.Engine.Enumeration.AnimationEnum;
import com.diarrmoh.Model.Engine.Enumeration.Orientation;
import com.diarrmoh.Model.Engine.InPut.InPut;
import com.diarrmoh.Model.Engine.Physics.Physics;
import com.diarrmoh.Model.Engine.Projectile;
import com.diarrmoh.Model.game.ForestFightQuest;
import com.diarrmoh.Model.game.Renderer;
import javafx.geometry.Point3D;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;

public abstract class Character implements Characters {

    protected String name;

    protected ImageView imageView;

    protected ImageView playerIcon;

    protected ProgressBar playerHealthBar;

    protected ProgressBar playerUltiBar;

    protected LinkedList<ImageView> projectileImageView;

    protected InPut inPut;

    protected Physics physics;

    protected Renderer renderer;

    protected boolean selected;

    protected boolean jumping;

    protected boolean canJump;

    protected boolean inAttack;

    protected boolean isDying;

    protected AnimationEnum animationState;

    protected Orientation orientation;

    protected double speed;

    protected double healthPoint;

    protected double ultiPoint;

    protected double damage;

    protected double maxHealth;

    protected double maxUlti;

    protected Origin origin;

    protected Element element;

    public Character(String name, ImageView imageView, LinkedList<ImageView> projectileImageView, int playerNum, boolean selected) {

        this.isDying = false;

        this.projectileImageView = projectileImageView;

        this.jumping = false;

        this.inAttack = false;

        this.orientation = Orientation.LEFT_TO_RIGHT;

        this.animationState = AnimationEnum.IDLE;

        this.speed = 10;

        this.selected = selected;

        this.name = name;

        physics = new Physics(this, null);

        inPut = new InPut(this, playerNum);

        renderer = new Renderer(this, null);

        this.imageView = imageView;

    }

    public void configImageView() {
        this.imageView.setRotationAxis(new Point3D(0,1,0));
        this.imageView.setX(physics.getPoint().getX());
        this.imageView.setY(physics.getPoint().getY());
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public Physics getPhysics() {
        return physics;
    }

    @Override
    public void setPhysics(Physics physics) {
        this.physics = physics;
    }

    @Override
    public InPut getInPut() {
        return inPut;
    }

    @Override
    public void setInPut(InPut inPut) {
        this.inPut = inPut;
    }

    @Override
    public Renderer getRenderer() {
        return renderer;
    }

    @Override
    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public AnimationEnum getAnimationState() {
        return animationState;
    }

    @Override
    public void setAnimationState(AnimationEnum animationState) {
        this.animationState = animationState;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public boolean isJumping() {
        return jumping;
    }

    @Override
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    @Override
    public Origin getOrigin() {
        return origin;
    }

    @Override
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    @Override
    public Element getElement() {
        return element;
    }

    @Override
    public void setElement(Element element) {
        this.element = element;
    }

    @Override
    public boolean canJump() {
        return canJump;
    }

    @Override
    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    public boolean isCanJump() {
        return canJump;
    }

    @Override
    public boolean isInAttack() {
        return inAttack;
    }

    @Override
    public void setInAttack(boolean inAttack) {
        this.inAttack = inAttack;
    }

    public LinkedList<ImageView> getProjectileImageView() {
        return projectileImageView;
    }

    public void setProjectileImageView(LinkedList<ImageView> projectileImageView) {
        this.projectileImageView = projectileImageView;
    }

    @Override
    public double getHealthPoint() {
        return healthPoint;
    }

    @Override
    public void setHealthPoint(double healthPoint) {
        if (healthPoint > 0) this.healthPoint = healthPoint;
        else this.healthPoint = 0;
    }

    @Override
    public double getUltiPoint() {
        return ultiPoint;
    }

    @Override
    public void setUltiPoint(double ultiPoint) {
        if (ultiPoint > 0) this.ultiPoint = ultiPoint;
        else this.ultiPoint = 0;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public ImageView getPlayerIcon() {
        return playerIcon;
    }

    @Override
    public void setPlayerIcon(ImageView playerIcon) {
        this.playerIcon = playerIcon;
    }

    @Override
    public ProgressBar getPlayerHealthBar() {
        return playerHealthBar;
    }

    @Override
    public void setPlayerHealthBar(ProgressBar playerHealthBar) {
        this.playerHealthBar = playerHealthBar;
    }

    @Override
    public ProgressBar getPlayerUltiBar() {
        return playerUltiBar;
    }

    @Override
    public void setPlayerUltiBar(ProgressBar playerUltiBar) {
        this.playerUltiBar = playerUltiBar;
    }

    @Override
    public double getMaxHealth() {
        return maxHealth;
    }

    @Override
    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public double getMaxUlti() {
        return maxUlti;
    }

    @Override
    public void setMaxUlti(double maxUlti) {
        this.maxUlti = maxUlti;
    }

    @Override
    public boolean isDying() {
        return isDying;
    }

    public void setIsDying(boolean isDying) {
        this.isDying = isDying;
    }

    @Override
    public void attack() {
        for (ImageView imageView : projectileImageView){
            if (imageView.getImage() == null){
                ForestFightQuest.projectiles.add(new Projectile(imageView,this));
                return;
            }
        }
    }
}
