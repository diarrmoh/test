package com.diarrmoh;

import com.diarrmoh.Model.Character.Colossus.RockGolem;
import com.diarrmoh.Model.Character.Garden.Archer;
import com.diarrmoh.Model.Character.Sorcerer.Wizard;
import com.diarrmoh.Model.Engine.Projectile;
import com.diarrmoh.Model.Sound.Sound;
import com.diarrmoh.Model.Engine.Engine;
import com.diarrmoh.Model.game.GameMode;
import com.studiohartman.jamepad.ControllerManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class   Launcher extends Application {
    public static Stage stage;
    public static Sound menuSound;
    public static Parent[] root;
    public static Parent gameRoot;
    public static Thread menuThread;
    public static Thread LobbyThread;
    public static Thread gameThread;
    public static Thread stateThread;
    public static ControllerManager controllerManager;
    public static GameMode gameMode;
    public static Engine engine;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        stage.setTitle("ForestQuest");
        stage.setScene(new Scene(root[0]));
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        controllerManager = new ControllerManager();
        controllerManager.initSDLGamepad();
        menuSound = new Sound(String.valueOf(Launcher.class.getResource("Data/Sound/Heavenless_Epic_dramatic_trailer.mp3")),true);
        root = new Parent[3];
        Archer.loadImage();
        RockGolem.loadImage();
        Wizard.loadImage();
        Projectile.load();
        Launcher.root[0] = Launcher.setRoot("View/MenuView.fxml");
        Launcher.root[1] = Launcher.setRoot("View/SettingView.fxml");
        Launcher.root[2] = Launcher.setRoot("View/LobbyView.fxml");
        launch(args);
    }

    public static Parent setRoot(String path) throws IOException {
        Parent root = FXMLLoader.load(Launcher.class.getResource(path));
        return root;
    }

    public static void setScene(Parent root){
        stage.getScene().setRoot(root);
    }

}
