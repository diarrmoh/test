package com.diarrmoh.Model.game;

import com.diarrmoh.Model.Character.Characters;
import com.diarrmoh.Model.Character.Colossus.RockGolem;
import com.diarrmoh.Model.Character.Garden.Archer;
import com.diarrmoh.Model.Character.Sorcerer.Wizard;
import com.diarrmoh.Model.Engine.Engine;
import com.diarrmoh.Model.Engine.Timer;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Arrays;
import java.util.LinkedList;

import static com.diarrmoh.Launcher.*;

public class GameMode implements Runnable {

    private ImageView[][] projectileImageViews;

    private Characters[] players;

    private ImageView player1;

    private ImageView player2;

    private ImageView player3;

    private ImageView player4;

    private ImageView playerOneIcon;

    private ImageView playerTwoIcon;

    private ImageView playerThreeIcon;

    private ImageView playerFourIcon;

    private ProgressBar playerOneHealphBar;

    private ProgressBar playerTwoHealphBar;

    private ProgressBar playerThreeHealphBar;

    private ProgressBar playerFourHealphBar;

    private ProgressBar playerOneUltiBar;

    private ProgressBar playerTwoUltiBar;

    private ProgressBar playerThreeUltiBar;

    private ProgressBar playerFourUltiBar;

    private Timer timer;

    private int nbOfPlayer;

    Pane menuRoot;

    Pane gamePane;

    Pane backgroundPane;


    public GameMode(Characters[] players, int nbOfPlayer) {
        this.players = players;

        this.timer = new Timer();

        this.nbOfPlayer = nbOfPlayer;
    }

    public void inPause(boolean b) {
        menuRoot.setVisible(b);
        menuRoot.setDisable(!b);
    }

    public void setConfig(){

        players[0].setImageView(player1);
        players[0].configImageView();
        playerOneIcon.setImage(players[0].getIconImage());
        players[0].setPlayerIcon(playerOneIcon);
        players[0].setPlayerHealthBar(playerOneHealphBar);
        players[0].setPlayerUltiBar(playerOneUltiBar);

        players[1].setImageView(player2);
        players[1].configImageView();
        playerTwoIcon.setImage(players[1].getIconImage());
        players[1].setPlayerIcon(playerTwoIcon);
        players[1].setPlayerHealthBar(playerTwoHealphBar);
        players[1].setPlayerUltiBar(playerTwoUltiBar);

        players[2].setImageView(player3);
        players[2].configImageView();
        playerThreeIcon.setImage(players[2].getIconImage());
        players[2].setPlayerIcon(playerThreeIcon);
        players[2].setPlayerHealthBar(playerThreeHealphBar);
        players[2].setPlayerUltiBar(playerThreeUltiBar);

        players[3].setImageView(player4);
        players[3].configImageView();
        playerFourIcon.setImage(players[3].getIconImage());
        players[3].setPlayerIcon(playerFourIcon);
        players[3].setPlayerHealthBar(playerFourHealphBar);
        players[3].setPlayerUltiBar(playerFourUltiBar);

        for (int i = 0; i < players.length; i++){
            if (players[i].getClass().equals(Archer.class)){
                players[i].setProjectileImageView(new LinkedList<ImageView>(Arrays.asList(projectileImageViews[0])));
                players[i].setCanJump(true);
            } else if (players[i].getClass().equals(RockGolem.class)){
                players[i].setProjectileImageView(new LinkedList<ImageView>(Arrays.asList(projectileImageViews[1])));
                players[i].setCanJump(false);
            } else if (players[i].getClass().equals(Wizard.class)){
                players[i].setProjectileImageView(new LinkedList<ImageView>(Arrays.asList(projectileImageViews[2])));
                players[i].setCanJump(true);
            }
        }
        engine = new Engine(new ForestFightQuest(players));

        gameThread = new Thread(engine);
        gameThread.start();

        stateThread = new Thread(this);
        stateThread.start();
    }

    public void run() {

        boolean running = true;
        while (running) {

            updateGameState();

            sync();
        }
    }

    private void updateGameState() {
        for (int i = 0; i < players.length; i++){
            players[i].getPlayerHealthBar().setProgress(players[i].getHealthPoint()/players[i].getMaxHealth());
            players[i].getPlayerUltiBar().setProgress(players[i].getMaxUlti()/players[i].getMaxUlti());
        }
    }

    private void sync() {
        float loopSlot = 1f / 25;
        double endTime = timer.getTime() + loopSlot;
        while (timer.getTime() < endTime) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ie) {
            }
        }
    }



    public Pane getMenuRoot() {
        return menuRoot;
    }

    public void setMenuRoot(Pane menuRoot) {
        this.menuRoot = menuRoot;
    }

    public Pane getGamePane() {
        return gamePane;
    }

    public void setGamePane(Pane gamePane) {
        this.gamePane = gamePane;
    }

    public Pane getBackgroundPane() {
        return backgroundPane;
    }

    public void setBackgroundPane(Pane backgroundPane) {
        this.backgroundPane = backgroundPane;
    }

    public ImageView[][] getProjectileImageViews() {
        return projectileImageViews;
    }

    public void setProjectileImageViews(ImageView[][] projectileImageViews) {
        this.projectileImageViews = projectileImageViews;
    }

    public ImageView getPlayer1() {
        return player1;
    }

    public void setPlayer1(ImageView player1) {
        this.player1 = player1;
    }

    public ImageView getPlayer2() {
        return player2;
    }

    public void setPlayer2(ImageView player2) {
        this.player2 = player2;
    }

    public ImageView getPlayer3() {
        return player3;
    }

    public void setPlayer3(ImageView player3) {
        this.player3 = player3;
    }

    public ImageView getPlayer4() {
        return player4;
    }

    public void setPlayer4(ImageView player4) {
        this.player4 = player4;
    }

    public ImageView getPlayerOneIcon() {
        return playerOneIcon;
    }

    public void setPlayerOneIcon(ImageView playerOneIcon) {
        this.playerOneIcon = playerOneIcon;
    }

    public ImageView getPlayerTwoIcon() {
        return playerTwoIcon;
    }

    public void setPlayerTwoIcon(ImageView playerTwoIcon) {
        this.playerTwoIcon = playerTwoIcon;
    }

    public ImageView getPlayerThreeIcon() {
        return playerThreeIcon;
    }

    public void setPlayerThreeIcon(ImageView playerThreeIcon) {
        this.playerThreeIcon = playerThreeIcon;
    }

    public ImageView getPlayerFourIcon() {
        return playerFourIcon;
    }

    public void setPlayerFourIcon(ImageView playerFourIcon) {
        this.playerFourIcon = playerFourIcon;
    }

    public ProgressBar getPlayerOneHealphBar() {
        return playerOneHealphBar;
    }

    public void setPlayerOneHealphBar(ProgressBar playerOneHealphBar) {
        this.playerOneHealphBar = playerOneHealphBar;
    }

    public ProgressBar getPlayerTwoHealphBar() {
        return playerTwoHealphBar;
    }

    public void setPlayerTwoHealphBar(ProgressBar playerTwoHealphBar) {
        this.playerTwoHealphBar = playerTwoHealphBar;
    }

    public ProgressBar getPlayerThreeHealphBar() {
        return playerThreeHealphBar;
    }

    public void setPlayerThreeHealphBar(ProgressBar playerThreeHealphBar) {
        this.playerThreeHealphBar = playerThreeHealphBar;
    }

    public ProgressBar getPlayerFourHealphBar() {
        return playerFourHealphBar;
    }

    public void setPlayerFourHealphBar(ProgressBar playerFourHealphBar) {
        this.playerFourHealphBar = playerFourHealphBar;
    }

    public ProgressBar getPlayerOneUltiBar() {
        return playerOneUltiBar;
    }

    public void setPlayerOneUltiBar(ProgressBar playerOneUltiBar) {
        this.playerOneUltiBar = playerOneUltiBar;
    }

    public ProgressBar getPlayerTwoUltiBar() {
        return playerTwoUltiBar;
    }

    public void setPlayerTwoUltiBar(ProgressBar playerTwoUltiBar) {
        this.playerTwoUltiBar = playerTwoUltiBar;
    }

    public ProgressBar getPlayerThreeUltiBar() {
        return playerThreeUltiBar;
    }

    public void setPlayerThreeUltiBar(ProgressBar playerThreeUltiBar) {
        this.playerThreeUltiBar = playerThreeUltiBar;
    }

    public ProgressBar getPlayerFourUltiBar() {
        return playerFourUltiBar;
    }

    public void setPlayerFourUltiBar(ProgressBar playerFourUltiBar) {
        this.playerFourUltiBar = playerFourUltiBar;
    }
}
