package com.example.nbamanager;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class EditarEquipoIntermedio {
    @FXML
    private ListView<Jugadores> playerListView;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnJugar;
    @FXML
    private Button btnseleccionarJugador;
    private ObservableList<Jugadores> jugadores;
    private Equipo equipoMain;
    public Equipo getEquipoMain() {
        return equipoMain;
    }
    private ArrayList<Jugadores> selectedPlayersList;

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

    @FXML
    private void initialize() {
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
        playerListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public static int resultadoMainTotal = 0;
    public static int resultadoEquipoMain = 0 ;
    public static int resultadoEquipoFacil = 0 ;

    @FXML
    void seleccionarJugador(ActionEvent event) {
        ObservableList<Jugadores> selectedPlayers = playerListView.getSelectionModel().getSelectedItems();
        selectedPlayersList = new ArrayList<>(selectedPlayers);

        equipoMain = new Equipo("EquipoMain");

        for (Jugadores jugador : selectedPlayers) {
            Jugadores nuevoJugador = new Jugadores(jugador.getNombre(), jugador.getTiro(), jugador.getDestreza(),
                    jugador.getDefensa(), jugador.getPosicion());
            System.out.println("Jugador seleccionado: " + jugador.getNombre());

            equipoMain.agregarJugador(nuevoJugador);
        }

        if (selectedPlayersList.size() == 5) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Equipo seleccionado");
            alert.setHeaderText(null);
            alert.setContentText("Equipo seleccionado: " + equipoMain.getNombre());
            alert.showAndWait();
        }

        Equipo equipoMain = getEquipoMain();
        Equipo equipoInter = new Equipo("EquipoInter");

        equipoInter.agregarJugador(new Jugadores("Joel Embid", 79, 89, 90, "Pivot"));
        equipoInter.agregarJugador(new Jugadores("Ja Morant", 60, 90, 60, "Base"));
        equipoInter.agregarJugador(new Jugadores("Kevin Durant", 90, 80, 70, "Alero"));
        equipoInter.agregarJugador(new Jugadores("Stephen Curry", 99, 85, 65, "Base"));
        equipoInter.agregarJugador(new Jugadores("Demar Derozan", 79, 80, 80, "Escolta"));

        ArrayList<Jugadores> jugadoresMain = equipoMain.obtenerJugadores();
        ArrayList<Jugadores> jugadoresInter = equipoInter.obtenerJugadores();

        for (int i = 0; i < jugadoresMain.size(); i++) {
            Jugadores jugadorMain = jugadoresMain.get(i);
            Jugadores jugadorInter = jugadoresInter.get(i);

            int diferenciaTiro = jugadorMain.getTiro() - jugadorInter.getTiro();
            int diferenciaDestreza = jugadorMain.getDestreza() - jugadorInter.getDestreza();
            int diferenciaDefensa = jugadorMain.getDefensa() - jugadorInter.getDefensa();

            int diferenciaFinal = diferenciaTiro + diferenciaDestreza + diferenciaDefensa;
            resultadoMainTotal = resultadoMainTotal + diferenciaFinal;
            System.out.println("Diferencia del jugador " + jugadorMain.getNombre() + " con " + jugadorInter + " :");
            System.out.println("Diferencia de tiro: " + diferenciaTiro);
            System.out.println("Diferencia de destreza: " + diferenciaDestreza);
            System.out.println("Diferencia de defensa: " + diferenciaDefensa);

            System.out.println("Diferencia total actual : " + resultadoMainTotal);
        }
    }

    @FXML
    void jugar(ActionEvent event) {
        if (resultadoMainTotal > 0 && resultadoMainTotal < 10) {
            resultadoEquipoMain = (int) (Math.random() * 21) + 90;

            System.out.println("Puntos de tu equipo = " + resultadoEquipoMain);
            resultadoEquipoFacil = (int) (Math.random() * 16) + 85;
            System.out.println("Puntos del rival = " + resultadoEquipoFacil);
        } else if (resultadoMainTotal < 0 && resultadoMainTotal > -10) {
            resultadoEquipoMain = (int) (Math.random() * 16) + 85;
            System.out.println("Puntos de tu equipo = " + resultadoEquipoMain);
            resultadoEquipoFacil = (int) (Math.random() * 21) + 90;
            System.out.println("Puntos del rival = " + resultadoEquipoFacil);
        } else if (resultadoMainTotal < -10) {
            resultadoEquipoMain = (int) (Math.random() * 16) + 75;
            System.out.println("Puntos de tu equipo = " + resultadoEquipoMain);
            resultadoEquipoFacil = (int) (Math.random() * 26) + 85;
            System.out.println("Puntos del rival = " + resultadoEquipoFacil);
        } else {
            resultadoEquipoMain = (int) (Math.random() * 26) + 85;
            System.out.println("Increíble! Puntos de tu equipo = " + resultadoEquipoMain);
            resultadoEquipoFacil = (int) (Math.random() * 14) + 75;
            System.out.println("Puntos del rival = " + resultadoEquipoFacil);
        }
        // Mostrar la ventana "JugandoFacil"
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JugandoInter.fxml"));
        try {
            Parent root = fxmlLoader.load();
            JugandoFacil controller = fxmlLoader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Jugando - Fácil");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stagePrincipal = (Stage) btnJugar.getScene().getWindow();
        stagePrincipal.close();
    }
}
