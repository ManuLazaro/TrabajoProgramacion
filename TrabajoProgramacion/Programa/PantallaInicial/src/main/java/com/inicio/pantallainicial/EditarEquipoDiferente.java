package com.inicio.pantallainicial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditarEquipoDiferente extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/inicio/pantallainicial/EditarEquipoDiferente.fxml"));


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Selección de Jugadores");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

