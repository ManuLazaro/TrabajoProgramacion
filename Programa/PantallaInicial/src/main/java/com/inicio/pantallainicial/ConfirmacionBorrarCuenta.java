package com.inicio.pantallainicial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmacionBorrarCuenta {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private TextField txtConfContraseña;

    @FXML
    void cancelar(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Cuenta.fxml"));
        try {
            Parent root = (Parent)fxmlLoader.load();
            Cuenta controlador = (Cuenta) fxmlLoader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("NBA Manager");
            stage.setScene(scene);
            stage.show();
        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }

        Stage stagePrincipal = (Stage)this.btnCancelar.getScene().getWindow();
        stagePrincipal.close();
    }

    @FXML
    void confirmar(ActionEvent event) {
        DBManager.loadDriver();
        DBManager.connect();
        DBManager.isConnected();
        if(DBManager.borrarCuenta(txtConfContraseña.getText())){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Exito");
            aviso.setHeaderText("Cuenta borrada con exito con exito");
            aviso.showAndWait();

            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("PantallaInicial.fxml"));
            try {
                Parent root = (Parent)fxmlLoader.load();
                InicioController controlador = (InicioController)fxmlLoader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("NBA Manager");
                stage.setScene(scene);
                stage.show();

                DBManager.close();
            } catch (IOException var7) {
                throw new RuntimeException(var7);
            }

            Stage stagePrincipal = (Stage)this.btnConfirmar.getScene().getWindow();
            stagePrincipal.close();
        } else {
            Alert er = new Alert(Alert.AlertType.ERROR);
            er.setTitle("Error");
            er.setHeaderText("Contraseña incorrecta");
            er.showAndWait();

            DBManager.close();
        }

    }

}