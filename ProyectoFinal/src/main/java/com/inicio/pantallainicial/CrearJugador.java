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

public class CrearJugador {

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtPosicion;

    @FXML
    private TextField txtAtaque;

    @FXML
    private TextField txtDefensa;

    @FXML
    private TextField txtDestreza;

    @FXML
    private TextField txtNombre;

    @FXML
    void crear(ActionEvent event) {

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
        //prueba
    }
    void botonAlta(ActionEvent event) {
        DBManager.loadDriver();
        DBManager.connect();
        boolean exito= DBManager.insertJugador(txtNombre.getText(),txtAtaque.getText(),txtDefensa.getText(),txtDestreza.getText(), txtPosicion.getText());
        DBManager.printTablaJugadores();
        if (exito) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Jugador añadido correctamente");
            alert.showAndWait();
            // Cerrar ventana
            Stage stage = (Stage) this.btnCrear.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.showAndWait();
        }
    }

}




