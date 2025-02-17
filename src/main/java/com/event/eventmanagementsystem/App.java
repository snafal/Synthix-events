package com.event.eventmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.util.Objects;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("app.fxml")));
        Scene scene = new Scene(root,800,600);
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(false);
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/event/eventmanagementsystem/Media/icon.png")));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Event Management System");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}