package com.diarrmoh.Model.Engine;

public interface Game {

    void init();

    void input();

    void update(float interval);
    
    void render();
}