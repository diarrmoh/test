package com.diarrmoh.Controller;

import com.diarrmoh.Model.Engine.Platforms;
import com.diarrmoh.Launcher;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ResourceBundle;

import static com.diarrmoh.Launcher.*;

public class GameController implements Initializable {
    public ImageView player1;
    public Pane menuPane;
    public Pane gamePane;
    public ImageView player2;
    public ImageView arrow1;
    public ImageView arrow2;
    public ImageView arrow3;
    public ImageView arrow4;
    public ImageView arrow5;
    public ImageView arrow6;
    public ImageView arrow7;
    public ImageView arrow8;
    public ImageView arrow9;
    public ImageView arrow10;
    public ImageView rock1;
    public ImageView rock2;
    public ImageView rock3;
    public ImageView rock4;
    public ImageView rock5;
    public ImageView rock6;
    public ImageView rock7;
    public ImageView rock8;
    public ImageView rock9;
    public ImageView rock10;
    public ImageView plateform1;
    public ImageView plateform2;
    public ImageView plateform3;
    public ImageView plateform4;
    public ImageView plateform5;
    public ImageView playerOneIcon;
    public ImageView playerTwoIcon;
    public ImageView playerThreeIcon;
    public ImageView playerFourIcon;
    public ProgressBar playerOneHealphBar;
    public ProgressBar playerTwoHealphBar;
    public ProgressBar playerThreeHealphBar;
    public ProgressBar playerFourHealphBar;
    public ProgressBar playerOneUltiBar;
    public ProgressBar playerTwoUltiBar;
    public ProgressBar playerThreeUltiBar;
    public ProgressBar playerFourUltiBar;
    public ImageView player3;
    public ImageView player4;
    public ImageView wizard1;
    public ImageView wizard2;
    public ImageView wizard3;
    public ImageView wizard4;
    public ImageView wizard5;
    public ImageView wizard6;
    public ImageView wizard7;
    public ImageView wizard8;
    public ImageView wizard9;
    public ImageView wizard10;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        gameMode.setMenuRoot(menuPane);
        gameMode.setProjectileImageViews(getProjectileImageView());

        gameMode.setPlayer1(player1);
        gameMode.setPlayerOneIcon(playerOneIcon);
        gameMode.setPlayerOneHealphBar(playerOneHealphBar);
        gameMode.setPlayerOneUltiBar(playerOneUltiBar);

        gameMode.setPlayer2(player2);
        gameMode.setPlayerTwoIcon(playerTwoIcon);
        gameMode.setPlayerTwoHealphBar(playerTwoHealphBar);
        gameMode.setPlayerTwoUltiBar(playerTwoUltiBar);

        gameMode.setPlayer3(player3);
        gameMode.setPlayerThreeIcon(playerThreeIcon);
        gameMode.setPlayerThreeHealphBar(playerThreeHealphBar);
        gameMode.setPlayerThreeUltiBar(playerThreeUltiBar);

        gameMode.setPlayer4(player4);
        gameMode.setPlayerFourIcon(playerFourIcon);
        gameMode.setPlayerFourHealphBar(playerFourHealphBar);
        gameMode.setPlayerFourUltiBar(playerFourUltiBar);

        Platforms platforms1 = new Platforms(plateform1);
        Platforms platforms2 = new Platforms(plateform2);
        Platforms platforms3 = new Platforms(plateform3);
        Platforms platforms4 = new Platforms(plateform4);
        Platforms platforms5 = new Platforms(plateform5);

        gameMode.setConfig();

    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        gameThread.stop();
    }

    public void backToMenu(ActionEvent actionEvent) throws Exception {
        Launcher.root[0] = Launcher.setRoot("View/MenuView.fxml");
        Launcher.root[1] = Launcher.setRoot("View/SettingView.fxml");
        Launcher.root[2] = Launcher.setRoot("View/LobbyView.fxml");
        Launcher.setScene(Launcher.root[0]);
    }

    private ImageView[][] getProjectileImageView(){
        ImageView[][] imageViews = new ImageView[3][10];

        imageViews[0][0] = arrow1;
        imageViews[0][1] = arrow2;
        imageViews[0][2] = arrow3;
        imageViews[0][3] = arrow4;
        imageViews[0][4] = arrow5;
        imageViews[0][5] = arrow6;
        imageViews[0][6] = arrow7;
        imageViews[0][7] = arrow8;
        imageViews[0][8] = arrow9;
        imageViews[0][9] = arrow10;

        imageViews[1][0] = rock1;
        imageViews[1][1] = rock2;
        imageViews[1][2] = rock3;
        imageViews[1][3] = rock4;
        imageViews[1][4] = rock5;
        imageViews[1][5] = rock6;
        imageViews[1][6] = rock7;
        imageViews[1][7] = rock8;
        imageViews[1][8] = rock9;
        imageViews[1][9] = rock10;

        imageViews[2][0] = wizard1;
        imageViews[2][1] = wizard2;
        imageViews[2][2] = wizard3;
        imageViews[2][3] = wizard4;
        imageViews[2][4] = wizard5;
        imageViews[2][5] = wizard6;
        imageViews[2][6] = wizard7;
        imageViews[2][7] = wizard8;
        imageViews[2][8] = wizard9;
        imageViews[2][9] = wizard10;

        return imageViews;
    }
}
