package com.inicio.pantallainicial;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Estadisticas {

    @FXML
    private TableColumn<Resultados, String> columDificultad;

    @FXML
    private TableColumn<Resultados, String> columResultado;

    @FXML
    private TableColumn<Resultados, String> columUsuario;

    @FXML
    private TableView<Resultados> tableEstadisticas;

    @FXML
    private Button btnVolver;

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

    private ObservableList<Resultados> lista = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Obtener los resultados de la base de datos y cargarlos en la lista
        lista = FXCollections.observableArrayList();
        DBManager.loadDriver();
        DBManager.connect();
        DBManager.isConnected();
        ResultSet rs = DBManager.getTablaEstadisticas(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        if (rs != null) {
            try {
                while (rs.next()) {
                    String nombre = rs.getString("nombreUsuarios");
                    String Dificultad = rs.getString("Dificultad");
                    String resultado = rs.getString("Resultado");
                    lista.add(new Resultados(nombre, Dificultad, resultado));
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        columUsuario.setCellValueFactory(new PropertyValueFactory<>("NombreUsuarios"));
        columDificultad.setCellValueFactory(new PropertyValueFactory<>("Dificultad"));
        columResultado.setCellValueFactory(new PropertyValueFactory<>("Resultado"));
        tableEstadisticas.setItems(lista);
        DBManager.close();
    }
}