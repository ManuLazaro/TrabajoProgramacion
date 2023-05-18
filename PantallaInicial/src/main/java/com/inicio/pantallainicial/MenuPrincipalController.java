package com.inicio.pantallainicial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {

    @FXML
    private Button btnCrearJugador;

    @FXML
    private Button btnEditarEquipo;

    @FXML
    private Button btnEstadisticas;

    @FXML
    private Button btnJugar;

    @FXML
    private Button btnSalir;

    @FXML
    void crearJugador(ActionEvent event) {

    }

    @FXML
    void editarEquipo(ActionEvent event) {

    }

    @FXML
    void estadisticas(ActionEvent event) {

    }

    @FXML
    void jugar(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PantallaInicial.fxml"));
        try{
            Parent root = fxmlLoader.load();
            InicioController controlador = fxmlLoader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("NBA Manager");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        Stage stagePrincipal = (Stage) btnSalir.getScene().getWindow();
        stagePrincipal.close();
    }

}
