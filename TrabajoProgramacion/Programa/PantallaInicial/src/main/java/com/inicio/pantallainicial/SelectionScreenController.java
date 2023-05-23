package com.inicio.pantallainicial;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SelectionScreenController {
    @FXML
    private ListView<Jugadores> playerListView;

    private ObservableList<Jugadores> jugadores;

    public SelectionScreenController() {
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
        playerListView.setItems(jugadores);
    }

    @FXML
    private void selectPlayers() {
        ObservableList<Jugadores> selectedPlayers = playerListView.getSelectionModel().getSelectedItems();

        // Aquí puedes realizar alguna acción con los jugadores seleccionados, como almacenarlos en una lista o hacer algo más con ellos.
        // Por ejemplo, puedes imprimir sus nombres:
        for (Jugadores jugador : selectedPlayers) {
            System.out.println(jugador.getNombre());
        }
    }
}


