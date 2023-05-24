package com.inicio.pantallainicial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EditarEquipoController {
    @FXML
    private ListView<Jugadores> playerListView;
    @FXML
    void btnVolver(ActionEvent event) {
    }
    private ObservableList<Jugadores> jugadores;



    public EditarEquipoController() {
        // Simulación de carga de jugadores desde la base de datos
        jugadores = FXCollections.observableArrayList(
                new Jugadores("Jugador 1", 80, 90, 70, "Delantero"),
                new Jugadores("Jugador 2", 85, 80, 75, "Base"),
                new Jugadores("Jugador 3", 90, 70, 85, "Pivot"),
                new Jugadores("Jugador 4", 75, 85, 90, "Ala-pívot")
        );
    }


        @FXML
        private void initialize() {
            // Obtener los jugadores de la base de datos y cargarlos en la lista
            jugadores = FXCollections.observableArrayList();
            ResultSet rs = DBManager.getTablaJugadores(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if (rs != null) {
                try {
                    while (rs.next()) {
                        String nombre = rs.getString("Nombre");
                        int tiro = rs.getInt("Tiro");
                        int destreza = rs.getInt("Destreza");
                        int defensa = rs.getInt("Defensa");
                        String posicion = rs.getString("Posicion");
                        jugadores.add(new Jugadores(nombre, tiro, destreza, defensa, posicion));
                    }
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            playerListView.setItems(jugadores);
        }


    @FXML
    private void seleccionarJugador() {
        ObservableList<Jugadores> selectedPlayers = playerListView.getSelectionModel().getSelectedItems();

        // Aquí puedes realizar alguna acción con los jugadores seleccionados, como almacenarlos en una lista o hacer algo más con ellos.
        // Por ejemplo, puedes imprimir sus nombres:
        for (Jugadores jugador : selectedPlayers) {
            System.out.println(jugador.getNombre());
        }
    }
}