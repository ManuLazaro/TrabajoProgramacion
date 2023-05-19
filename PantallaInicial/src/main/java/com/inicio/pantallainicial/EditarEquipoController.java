package com.inicio.pantallainicial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class EditarEquipoController {

    @FXML
    private Button btnAplicar;

    @FXML
    private Button btnVolver;

    @FXML
    private ComboBox<?> cmbAlapivot;

    @FXML
    private ComboBox<?> cmbAlero;

    @FXML
    private ComboBox<?> cmbBase;

    @FXML
    private ComboBox<?> cmbEscolta;

    @FXML
    private ComboBox<?> cmbPivot;

    @FXML
    private TableColumn<?, ?> colAtaque;

    @FXML
    private TableColumn<?, ?> colDefensa;

    @FXML
    private TableColumn<?, ?> colDestreza;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    void aplicarCambios(ActionEvent event) {

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