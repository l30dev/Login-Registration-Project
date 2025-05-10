package com.example.demo2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPage {
    private VBox layout;

    public LoginPage(Stage stage) {
        Label title = new Label("Login");
        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Button loginBtn = new Button("Login");
        Button toRegisterBtn = new Button("Register");

        layout = new VBox(10, title, username, password, loginBtn, toRegisterBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getStyleClass().add("login-box");

        loginBtn.setOnAction(e -> {
            if (Database.validateUser(username.getText(), password.getText())) {
                SuccessPage.show(stage, username.getText());
            } else {
                showAlert("Invalid credentials.");
            }
        });

        toRegisterBtn.setOnAction(e -> {
            RegisterPage registerPage = new RegisterPage(stage);
            Scene registerScene = new Scene(registerPage.getLayout(), 350, 400);
            registerScene.getStylesheets().add(getClass().getResource("/loginStyle.css").toExternalForm());
            stage.setScene(registerScene);
        });
    }

    public VBox getLayout() {
        return layout;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }
}