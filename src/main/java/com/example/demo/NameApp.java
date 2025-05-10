package com.example.demo;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NameApp extends Application {

    public static class Person {
        private final String name;

        public Person(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }
    }

    private final ObservableList<Person> people = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Enter Your Name:");
        TextField textField = new TextField();
        Button button = new Button("add to table!");

        TableView<Person> tableView = new TableView<>();
        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");

        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

        tableView.getColumns().add(nameColumn);
        tableView.setItems(people);

        button.setOnAction(e -> {
            String name = textField.getText();
            if(!name.isEmpty()){
                people.add(new Person(name));
                textField.clear();
            }
        });

        VBox layOut = new VBox(10);
        layOut.getChildren().addAll(label, textField, button, tableView);
        Scene scene = new Scene(layOut, 300, 400);
        scene.getStylesheets().add(getClass().getResource("/nameAppStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}