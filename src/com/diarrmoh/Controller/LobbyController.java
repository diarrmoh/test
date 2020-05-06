package com.diarrmoh.Controller;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Character.Character;
import com.diarrmoh.Model.Character.Characters;
import com.diarrmoh.Model.Character.Colossus.RockGolem;
import com.diarrmoh.Model.Character.Garden.Archer;
import com.diarrmoh.Model.Character.Sorcerer.Wizard;
import com.diarrmoh.Model.Engine.Engine;
import com.diarrmoh.Model.Engine.Enumeration.NumberOfPlayer;
import com.diarrmoh.Model.game.ForestFightQuest;
import com.diarrmoh.Model.game.GameMode;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.diarrmoh.Launcher.*;

public class LobbyController implements Initializable {
    public ImageView playerOne;
    public Text playerOneName;
    public Text playerOneElement;
    public Text playerOneOrigin;
    public Text playerTwoName;
    public ImageView playerTwo;
    public Text playerTwoElement;
    public Text playerTwoOrigin;
    public Text playerThreeName;
    public ImageView playerThree;
    public Text playerThreeElement;
    public Text playerThreeOrigin;
    public Text playerFourName;
    public ImageView playerFour;
    public Text playerFourElement;
    public Text playerFourOrigin;
    public Text[] playerName;
    public Text[] playerElement;
    public Text[] playerOrigin;
    public Archer[] archers;
    public RockGolem[] rockGolems;
    public Wizard[] wizards;
    public int playerOneCom;
    public int playerTwoCom;
    public int playerThreeCom;
    public int playerFourCom;
    public int playerNumberCom;
    public Text playerNumber;
    public String[] playerNumberSt;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menuSound.play();

    }

    private void load() throws IOException {
        loadCharacters();

        rockGolems[0].setImageView(playerOne);
        playerOneName.setText(rockGolems[0].getName());
        playerOneElement.setText(rockGolems[0].getElement().getName());
        playerOneOrigin.setText(rockGolems[0].getOrigin().getName());

        archers[1].setImageView(playerTwo);
        playerTwoName.setText(archers[1].getName());
        playerTwoElement.setText(archers[1].getElement().getName());
        playerTwoOrigin.setText(archers[1].getOrigin().getName());

        rockGolems[2].setImageView(playerThree);
        playerThreeName.setText(rockGolems[2].getName());
        playerThreeElement.setText(rockGolems[2].getElement().getName());
        playerThreeOrigin.setText(rockGolems[2].getOrigin().getName());

        archers[3].setImageView(playerFour);
        playerFourName.setText(archers[3].getName());
        playerFourElement.setText(archers[3].getElement().getName());
        playerFourOrigin.setText(archers[3].getOrigin().getName());

        playerNumberSt = new String[3];
        playerNumberSt[0] = NumberOfPlayer.OnePlayer.getName();
        playerNumberSt[1] = NumberOfPlayer.TwoPlayer.getName();
        playerNumberSt[2] = NumberOfPlayer.FourPlayer.getName();
        playerNumber.setText(playerNumberSt[0]);

        playerOneCom = 1;
        playerTwoCom = 0;
        playerThreeCom = 1;
        playerFourCom = 0;
        playerNumberCom = 0;

        Characters[] characters = new Characters[]{
                archers[0], archers[1], archers[2], archers[3],
                rockGolems[0], rockGolems[1], rockGolems[2], rockGolems[3],
                wizards[0], wizards[1], wizards[2], wizards[3],
        };

        Engine engine = new Engine(new ForestFightQuest(characters));

        indexPlayer();

        LobbyThread = new Thread(engine);
        LobbyThread.start();
    }

    private void loadCharacters(){
        archers = new Archer[4];
        rockGolems = new RockGolem[4];
        wizards = new Wizard[4];
        ImageView imageView = new ImageView();

        for (int i = 0; i < 4; i++){
            archers[i] = new Archer("Archer",imageView,null,0, false);
            rockGolems[i] = new RockGolem("Golem",imageView,null,0, false);
            wizards[i] = new Wizard("Wizard",imageView,null,0, false);
        }

    }

    public void play(ActionEvent actionEvent) throws IOException {
        root[0] = null;
        root[1] = null;
        root[2] = null;

        gameMode = new GameMode(getPlayers(), 2);

        gameRoot = Launcher.setRoot("View/GameView.fxml");
        setScene(gameRoot);
        menuSound.getMediaPlayer().stop();
        menuThread.stop();
        LobbyThread.stop();
    }

    private Characters[] getPlayers() {
        Characters[] characters = new Characters[2];

        playerSelect(characters, playerOneName, 0);

        playerSelect(characters, playerTwoName, 1);

//        playerSelect(characters, playerThreeName, 2);
//
//        playerSelect(characters, playerFourName, 3);


        return characters;
    }

    private void playerSelect(Characters[] characters, Text player, int i) {
        switch (player.getText()) {
            case "Archer" -> characters[i] = new Archer("Archer", null, null, i, true);
            case "Golem" -> characters[i] = new RockGolem("Golem", null, null, i, true);
            case "Wizard" -> characters[i] = new Wizard("Wizard", null, null, i, true);
        }
    }

    public void backToMenu(ActionEvent actionEvent) {
        Launcher.setScene(root[0]);
    }

    public void playerOneScrollLeft(ActionEvent actionEvent) {
        playerOneCom += 3;
        playerOneCom--;
        playerOneScroll();
    }

    private void scroll(int playerCom, ImageView imageView, int index) {
        playerCom %= 3;
        switch(playerCom) {
            case 0 -> {
                rockGolems[index].setImageView(null);
                wizards[index].setImageView(null);
                archers[index].setImageView(imageView);
                playerName[index].setText(archers[index].getName());
                playerElement[index].setText(archers[index].getElement().getName());
                playerOrigin[index].setText(archers[index].getOrigin().getName());
            }
            case 1 -> {
                archers[index].setImageView(null);
                wizards[index].setImageView(null);
                rockGolems[index].setImageView(imageView);
                playerName[index].setText(rockGolems[index].getName());
                playerElement[index].setText(rockGolems[index].getElement().getName());
                playerOrigin[index].setText(rockGolems[index].getOrigin().getName());
            }
            case 2 -> {
                rockGolems[index].setImageView(null);
                archers[index].setImageView(null);
                wizards[index].setImageView(imageView);
                playerName[index].setText(wizards[index].getName());
                playerElement[index].setText(wizards[index].getElement().getName());
                playerOrigin[index].setText(wizards[index].getOrigin().getName());
            }
        }
    }

    private void indexPlayer(){

        playerName = new Text[4];
        playerElement = new Text[4];
        playerOrigin = new Text[4];

        playerName[0] = playerOneName;
        playerName[1] = playerTwoName;
        playerName[2] = playerThreeName;
        playerName[3] = playerFourName;

        playerElement[0] = playerOneElement;
        playerElement[1] = playerTwoElement;
        playerElement[2] = playerThreeElement;
        playerElement[3] = playerFourElement;

        playerOrigin[0] = playerOneOrigin;
        playerOrigin[1] = playerTwoOrigin;
        playerOrigin[2] = playerThreeOrigin;
        playerOrigin[3] = playerFourOrigin;
    }

    private void playerOneScroll() {
        scroll(playerOneCom, playerOne, 0);
    }

    private void playerTwoScroll() {
        scroll(playerTwoCom, playerTwo, 1);
    }

    private void playerThreeScroll() {
        scroll(playerThreeCom, playerThree, 2);
    }

    private void playerFourScroll() {
        scroll(playerFourCom, playerFour, 3);
    }

    public void playerOneScrollRight(ActionEvent actionEvent) {
        playerOneCom++;
        playerOneScroll();
    }

    public void playerTwoScrollLeft(ActionEvent actionEvent) {
        playerTwoCom += 3;
        playerTwoCom--;
        playerTwoScroll();
    }

    public void playerTwoScrollRight(ActionEvent actionEvent) {
        playerTwoCom++;
        playerTwoScroll();
    }

    public void playerThreeScrollLeft(ActionEvent actionEvent) {
        playerThreeCom += 3;
        playerThreeCom--;
        playerThreeScroll();
    }

    public void playerThreeScrollRight(ActionEvent actionEvent) {
        playerThreeCom++;
        playerThreeScroll();
    }

    public void playerFourScrollLeft(ActionEvent actionEvent) {
        playerFourCom += 3;
        playerFourCom--;
        playerFourScroll();
    }

    public void playerFourScrollRight(ActionEvent actionEvent) {
        playerFourCom++;
        playerFourScroll();
    }

    public void playerNumberScrollRight(MouseEvent mouseEvent) {
        playerNumberCom++;
        playerNumberCom %= 3;
        playerNumber.setText(playerNumberSt[playerNumberCom]);
    }

    public void playerNumberScrollLeft(ActionEvent actionEvent) {
        playerNumberCom += 2;
        playerNumberCom %= 3;
        playerNumber.setText(playerNumberSt[playerNumberCom]);
    }


}
