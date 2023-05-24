package com.inicio.pantallainicial;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
    private TableColumn<?, ?> colPosicion;
    private TableView<Jugadores> tablaListado;
    private ObservableList<Jugadores> jugadores;

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
    void setBtnAplicar(ActionEvent event) {

    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Creo el observablelist
        jugadores = FXCollections.observableArrayList();

        // Asigno las columnas con los atributos
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colAtaque.setCellValueFactory(new PropertyValueFactory("tiro"));
        this.colDestreza.setCellValueFactory(new PropertyValueFactory("destreza"));
        this.colDefensa.setCellValueFactory(new PropertyValueFactory("defensa"));
        this.colPosicion.setCellValueFactory(new PropertyValueFactory("posicion"));

        try {
            DBManager.loadDriver();
            DBManager.connect();
            ResultSet rs = DBManager.getTablaJugadores();
            while (rs.next()) {
                int tiro = rs.getInt("tiro");
                String destreza = rs.getString("destreza");
                int defensa = rs.getInt("defensa");
                String nombre = rs.getString("nombre");
                String posicion = rs.getString("posicion");
                //System.out.println(" " + id + " - " + nombre + " - " + ciudad);
                this.jugadores.add(new Jugadores(nombre,tiro,destreza,defensa,posicion));
                this.tablaListado.setItems(this.jugadores);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}