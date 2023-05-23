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

public class InicioController {

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnRegistrarte;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtUsuario;

    @FXML
    void entrarConCuenta(ActionEvent event) {
        DBManager.loadDriver();
        DBManager.connect();
        DBManager.isConnected();
        boolean comprobacion = DBManager.getUsuario(txtUsuario.getText(), txtContraseña.getText());
        if (comprobacion == true) {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("MenuPrincipal.fxml"));

            try {
                Parent root = (Parent)fxmlLoader.load();
                MenuPrincipalController controlador = (MenuPrincipalController)fxmlLoader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("NBA Manager");
                stage.setScene(scene);
                stage.show();
            } catch (IOException var7) {
                throw new RuntimeException(var7);
            }

            Stage stagePrincipal = (Stage)this.btnEntrar.getScene().getWindow();
            stagePrincipal.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("La contraseña o eñ usuario son incorrectos");
            alert.showAndWait();
        }

        DBManager.close();
    }

    @FXML
    void registrarte(ActionEvent event) {
        DBManager.loadDriver();
        DBManager.connect();
        DBManager.isConnected();
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

        Stage stagePrincipal = (Stage) btnRegistrarte.getScene().getWindow();
        stagePrincipal.close();
        DBManager.close();
    }

}
