package com.diarrmoh.Controller;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Character.Characters;
import com.diarrmoh.Model.Character.Colossus.RockGolem;
import com.diarrmoh.Model.Character.Garden.Archer;
import com.diarrmoh.Model.Engine.Engine;
import com.diarrmoh.Model.game.ForestFightQuest;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.diarrmoh.Launcher.*;


public class MenuController implements Initializable {



    public ImageView image_G;
    public ImageView image_D;

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


        Archer archer = new Archer("Archer",image_G,null,0, false);

        RockGolem golem = new RockGolem("Golem",image_D,null,1, false);

        Characters[] characters = new Characters[]{
                archer,
                golem,
        };
        engine = new Engine(new ForestFightQuest(characters));

        menuThread = new Thread(engine);
        menuThread.start();
    }


    public void setting(ActionEvent actionEvent) {
        Launcher.setScene(Launcher.root[1]);
    }

    public void play(ActionEvent actionEvent) {
        Launcher.setScene(Launcher.root[2]);
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        menuThread.stop();
        LobbyThread.stop();
    }
}
