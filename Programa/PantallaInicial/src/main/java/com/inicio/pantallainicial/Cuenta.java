package com.inicio.pantallainicial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Cuenta {

    @FXML
    private Button btnBorrarCuenta;

    @FXML
    private Button btnCambiarClave;

    @FXML
    private Button btnCambiarNomUsuario;

    @FXML
    private Button btnVolver;

    @FXML
    void borrarCuenta(ActionEvent event) {

    }

    @FXML
    void cambiarClave(ActionEvent event) {

    }

    @FXML
    void cambiarNomUsuario(ActionEvent event) {

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

}