package com.diarrmoh.Controller;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Sound.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import static com.diarrmoh.Launcher.root;

public class SettingController implements Initializable {


    public Slider volumeBar;

    public void backToMenu(ActionEvent actionEvent) {
        Launcher.setScene(root[0]);
    }


    public void setVolume(MouseEvent mouseEvent) {
        Sound.setVolume(((Slider)mouseEvent.getSource()).getValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        volumeBar.setMin(0);
        volumeBar.setMax(1);
        volumeBar.setValue(Sound.getVolume());
    }
}
