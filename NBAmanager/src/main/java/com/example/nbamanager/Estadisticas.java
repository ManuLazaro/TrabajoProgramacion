package com.example.nbamanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Estadisticas {

    @FXML
    private Button btnVolver;
    @FXML
    private ListView<Usuarios> playerListView;
    private ObservableList<Usuarios> usuarios;

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

    private void initialize() {
        // Obtener los usuarios
        usuarios = FXCollections.observableArrayList();
        ResultSet rs = DBManager.getTablaEstadisticas(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        if (rs != null) {
            try {
                while (rs.next()) {
                    String nombre = rs.getString("Nombre");
                    String resultado = rs.getString("Resultado");
                    String dificultad = rs.getString("Dificultad");
                    usuarios.add(new Usuarios(nombre, resultado, dificultad));
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        playerListView.setItems(usuarios);
    }
}