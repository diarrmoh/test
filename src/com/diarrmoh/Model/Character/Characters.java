package com.diarrmoh.Model.Character;

import com.diarrmoh.Model.Engine.Enumeration.Element;
import com.diarrmoh.Model.Engine.Enumeration.Origin;
import com.diarrmoh.Model.Engine.Projectile;
import com.diarrmoh.Model.Engine.Enumeration.AnimationEnum;
import com.diarrmoh.Model.Engine.Enumeration.Orientation;
import com.diarrmoh.Model.Engine.InPut.InPut;
import com.diarrmoh.Model.Engine.Physics.Physics;
import com.diarrmoh.Model.game.Renderer;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;

public interface Characters {

    ImageView getImageView();

    void setImageView(ImageView imageView);

    Physics getPhysics();

    void setPhysics(Physics physics);

    InPut getInPut();

    void setInPut(InPut inPut);

    Renderer getRenderer();

    void setRenderer(Renderer renderer);

    double getSpeed();

    void setSpeed(double speed);

    Image[] getIdleImage();

    void setIdleImage(Image[] idleImage);

    boolean isSelected();

    void setSelected(boolean selected);

    boolean isDying();

    void setIsDying(boolean isDyind);

    AnimationEnum getAnimationState();

    void setAnimationState(AnimationEnum animationState);

    String getName();

    void setName(String name);

    Image[] getWalkImage();

    void setWalkImage(Image[] walkImage);

    Image[][] getJumpImage();

    void setJumpImage(Image[][] jumpImage);

    Image[] getDeathImage();

    void setDeathImage(Image[] deathImage);

    Image[][] getAttackImage();

    void setAttackImage(Image[][] attackImage);

    Orientation getOrientation();

    void setOrientation(Orientation orientation);

    boolean isJumping();

    void setJumping(boolean jumping);

    Origin getOrigin();

    void setOrigin(Origin origin);

    Element getElement();

    void setElement(Element element);

    boolean canJump();

    void setCanJump(boolean canJump);

    void attack();

    boolean isInAttack();

    void setInAttack(boolean inAttack);

    double getHealthPoint();

    void setHealthPoint(double healthPoint);

    double getUltiPoint();

    void setUltiPoint(double ultiPoint);

    double getDamage();

    void setDamage(double damage);

    void setProjectileImageView(LinkedList<ImageView> projectileImageView);

    LinkedList<ImageView> getProjectileImageView();

    void configImageView();

    ImageView getPlayerIcon();

    void setPlayerIcon(ImageView playerIcon);

    ProgressBar getPlayerHealthBar();

    void setPlayerHealthBar(ProgressBar playerHealthBar);

    ProgressBar getPlayerUltiBar();

    void setPlayerUltiBar(ProgressBar playerUltiBar);

    double getMaxHealth();

    void setMaxHealth(double maxHealth);

    double getMaxUlti();

    void setMaxUlti(double maxUlti);

    Image getIconImage();

    void setIconImage(Image iconImage);
}









