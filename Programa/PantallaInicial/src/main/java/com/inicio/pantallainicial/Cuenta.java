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
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("ConfirmacionBorrarCuenta.fxml"));
        try {
            Parent root = (Parent)fxmlLoader.load();
            ConfirmacionBorrarCuenta controlador = (ConfirmacionBorrarCuenta)fxmlLoader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Borrar cuenta");
            stage.setScene(scene);
            stage.show();
        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }

        Stage stagePrincipal = (Stage) btnBorrarCuenta.getScene().getWindow();
        stagePrincipal.close();
    }

    @FXML
    void cambiarClave(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("CambiarClave.fxml"));
        try {
            Parent root = (Parent)fxmlLoader.load();
            CambiarClave controlador = (CambiarClave)fxmlLoader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Cambiar Clave");
            stage.setScene(scene);
            stage.show();
        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }

        Stage stagePrincipal = (Stage) btnCambiarClave.getScene().getWindow();
        stagePrincipal.close();
    }

    @FXML
    void cambiarNomUsuario(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("CambiarNombreUsuario.fxml"));
        try {
            Parent root = (Parent)fxmlLoader.load();
            CambiarNombreUsuario controlador = (CambiarNombreUsuario)fxmlLoader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Cambiar Nombre");
            stage.setScene(scene);
            stage.show();
        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }

        Stage stagePrincipal = (Stage) btnCambiarNomUsuario.getScene().getWindow();
        stagePrincipal.close();
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