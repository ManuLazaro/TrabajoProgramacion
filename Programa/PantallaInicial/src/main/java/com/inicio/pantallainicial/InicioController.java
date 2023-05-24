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
        if (DBManager.getUsuario(txtUsuario.getText(), txtContraseña.getText()) == true) {
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
            alert.setHeaderText("La contraseña o el usuario son incorrectos");
            alert.showAndWait();
        }

        DBManager.close();
    }

    @FXML
    void registrarte(ActionEvent event) {
        DBManager.loadDriver();
        DBManager.connect();
        DBManager.isConnected();
        if(DBManager.registrar(txtUsuario.getText(), txtContraseña.getText()) == true){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Exito");
            aviso.setHeaderText("Cuenta creada con exito");
            aviso.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Esa cuenta ya existe");
            alert.showAndWait();
        }
        DBManager.close();
    }

}
