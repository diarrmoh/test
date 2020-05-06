package com.diarrmoh.Model.Engine.InPut;

import com.diarrmoh.Model.Character.Characters;
import com.diarrmoh.Model.Engine.Enumeration.AnimationEnum;
import com.studiohartman.jamepad.ControllerState;

import static com.diarrmoh.Launcher.controllerManager;
import static com.diarrmoh.Launcher.gameMode;


public class InPut {

    private static boolean pause = false;

    private Characters characters;

    private int playerNum;

    ControllerState state;


    public InPut(Characters characters) {
        this.characters = characters;
    }


    public InPut(Characters characters, int playerNum) {
        this.characters = characters;
        this.playerNum = playerNum;
    }

    public static boolean isPause() {
        return pause;
    }

    public static void setPause(boolean pause) {
        InPut.pause = pause;
    }

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public ControllerState getState(){
        return controllerManager.getState(playerNum);
    }

    public void Update() {
        if (!characters.isSelected()){

        } else {
            state = getState();
            if (state.startJustPressed){
                pause = !pause;
                gameMode.inPause(pause);
            } else {
                if (characters.isJumping() || characters.getAnimationState().equals(AnimationEnum.TOUCHDOWN)){
                    if (state.leftStickX < -0.1){
                        characters.getPhysics().moveX(characters.getPhysics().getPoint().getX() - characters.getSpeed());
                    } else if (state.leftStickX > 0.1){
                        characters.getPhysics().moveX(characters.getPhysics().getPoint().getX() + characters.getSpeed());
                    }
                } else if (characters.isInAttack()) {

                } else {
                    if (state.leftStickX < -0.1){
                        characters.setAnimationState(AnimationEnum.WALK_LEFT);
                    } else if (state.leftStickX > 0.1){
                        characters.setAnimationState(AnimationEnum.WALK_RIGHT);
                    }  else if (state.aJustPressed && characters.canJump()){
                        characters.setAnimationState(AnimationEnum.JUMPING);
                        characters.setJumping(true);
                        characters.setSpeed(5);
                    }  else if (state.x && !characters.getAnimationState().equals(AnimationEnum.ATTACK1)){
                        characters.setAnimationState(AnimationEnum.ATTACK1);
                        characters.setInAttack(true);
                    }  else if (state.b){

                    }  else if (state.y){
                        //characters.setAnimationState(AnimationEnum.ULTIMEATACK);
                    } else {
                        characters.setAnimationState(AnimationEnum.IDLE);
                    }
                }
            }
        }

    }
}
