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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Estadisticas {

    @FXML
    private TableColumn<?, ?> columDificultad;

    @FXML
    private TableColumn<?, ?> columResultado;

    @FXML
    private TableColumn<?, ?> columUsuario;

    @FXML
    private TableView<?> tableEstadisticas;

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

    public ObservableList<Resultados> lista = FXCollections.observableArrayList(
            new Resultados(DBManager.usuarioEstadisticas(), DBManager.dificultadEstadisticas(), DBManager.ResultadoEstadisticas())
    );


    @FXML
    private void initialize() {
        // Obtener los jugadores de la base de datos y cargarlos en la lista
        lista = FXCollections.observableArrayList();
        ResultSet rs = DBManager.getTablaEstadisticas(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        if (rs != null) {
            try {
                while (rs.next()) {
                    String nombre = rs.getString("nombreUsuarios");
                    String Dificultad = rs.getString("Dificultad");
                    int resultado = rs.getInt("Resultado");
                    lista.add(new Resultados(nombre, Dificultad, resultado));
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}