package com.example.nbamanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Dificultad {

    @FXML
    private Button btnDificil;

    @FXML
    private Button btnFacil;

    @FXML
    private Button btnIntermedio;

    @FXML
    private Button btnVolver;

    @FXML
    void partidaDificil(ActionEvent event) {

    }


    @FXML
    void partidaIntermedio(ActionEvent event) {

    }

    @FXML
    void volver(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuPrincipal.fxml"));
        try{
            Parent root = fxmlLoader.load();
            MenuPrincipalController controlador = fxmlLoader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("NBA Manager");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        Stage stagePrincipal = (Stage) btnVolver.getScene().getWindow();
        stagePrincipal.close();
    }
    @FXML
    void partidaFacil (ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditarEquipo.fxml"));
        try{
            Parent root = fxmlLoader.load();
            Dificultad controlador = fxmlLoader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("NBA Manager");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        Stage stagePrincipal = (Stage) btnFacil.getScene().getWindow();
        stagePrincipal.close();
    }
}
