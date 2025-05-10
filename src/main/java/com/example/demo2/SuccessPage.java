package com.example.demo2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SuccessPage {
    public static void show(Stage stage, String username) {
        Label success = new Label("Logged in successfully!");
        Label welcome = new Label("Welcome, " + username + "!");
        VBox layout = new VBox(10, success, welcome);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
    }
}
