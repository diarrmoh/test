package com.diarrmoh.Model.game;


import com.diarrmoh.Model.Character.Characters;
import com.diarrmoh.Model.Engine.Game;
import com.diarrmoh.Model.Engine.Projectile;

import java.util.LinkedList;

public class ForestFightQuest implements Game {

    private int direction = 0;
    
    private float color = 0.0f;

    private Characters[] characters;

    public static LinkedList<Projectile> projectiles  = new LinkedList<Projectile>();;

    
    public ForestFightQuest(Characters[] characters) {
        this.characters = characters;
    }
    
    @Override
    public void init() {

    }
    
    @Override
    public void input() {
        for (int i = 0; i < characters.length; i++){
            characters[i].getInPut().Update();
        }
    }

    @Override
    public void update(float interval) {
        for (int i = 0; i < characters.length; i++){
            characters[i].getPhysics().Update();
        }

        for (int i = 0; i < projectiles.size(); i++){
            projectiles.get(i).getPhysics().Update();
        }
    }

    @Override
    public void render() {
        for (int i = 0; i < characters.length; i++){
            characters[i].getRenderer().Update();
        }

        for (int i = 0; i < projectiles.size(); i++){
            projectiles.get(i).getRenderer().Update();
        }
    }
}
