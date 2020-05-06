package com.diarrmoh.Model.Sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Sound  {
    private Media media;
    private String source;
    private static MediaPlayer mediaPlayer;
    private boolean continuousStreaming;
    public static double volume;

    public Sound(String source, boolean continuousStreaming) {
        volume = 0.5;
        this.source = source;
        this.continuousStreaming = continuousStreaming;
        try {
            this.media = new Media(source);
            this.mediaPlayer = new MediaPlayer(this.media);
            setPlayerConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Sound() {
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void play(){

        mediaPlayer.play();
    }

    private void setPlayerConfig() {
        mediaPlayer.setOnReady(new Runnable(){
            public void run() {
                mediaPlayer.setStartTime(Duration.ZERO);
                mediaPlayer.setStopTime(media.getDuration().subtract(Duration.seconds(2)));
                mediaPlayer.setVolume(volume);
            }
        });
        mediaPlayer.setOnEndOfMedia(new Runnable(){
            public void run() {
                if (continuousStreaming){
                    mediaPlayer = new MediaPlayer(media);
                    setPlayerConfig();
                    mediaPlayer.play();
                }
                else mediaPlayer.stop();
            }
        });
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public boolean isContinuousStreaming() {
        return continuousStreaming;
    }

    public void setContinuousStreaming(boolean continuousStreaming) {
        this.continuousStreaming = continuousStreaming;
    }

    public static double getVolume() {
        return volume;
    }

    public static void setVolume(double volume) {
        Sound.volume = volume;
        mediaPlayer.setVolume(volume);

    }
}
