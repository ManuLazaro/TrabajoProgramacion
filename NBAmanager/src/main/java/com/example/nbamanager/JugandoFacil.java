package com.example.nbamanager;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Random;

import static com.example.nbamanager.EditarEquipoController.resultadoEquipoFacil;
import static com.example.nbamanager.EditarEquipoController.resultadoEquipoMain;


public class JugandoFacil {

    @FXML
    private Button btnJugar;

    @FXML
    private Button btnSalir;

    @FXML
    private Text txtPuntosRival;

    @FXML
    private Text txtPuntosUsuario;

    @FXML
    void jugar(ActionEvent event) {
        // Llamar a los métodos para establecer los valores de los textos
        setPuntosUsuario(resultadoEquipoMain);
        setPuntosRival(resultadoEquipoFacil);

        // Alertas segun el resultado
        if (resultadoEquipoMain > resultadoEquipoFacil) {
            // Alerta cuando resultadoEquipoMain es mayor que resultadoEquipoFacil
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Resultado del juego");
            alert.setHeaderText(null);
            alert.setContentText("¡Has ganado! ENHORABUENA.");
            alert.showAndWait();
        } else if (resultadoEquipoMain == resultadoEquipoFacil) {
            // Alerta cuando resultadoEquipoMain y resultadoEquipoFacil son iguales
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Resultado del juego");
            alert.setHeaderText(null);
            alert.setContentText("Has empatado, elige un mejor equipo la proxima vez.");
            alert.showAndWait();
        } else {
            // Alerta cuando resultadoEquipoFacil es mayor que resultadoEquipoMain
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Resultado del juego");
            alert.setHeaderText(null);
            alert.setContentText("Has perdido. El equipo rival fue mejor que tu.");
            alert.showAndWait();
        }
    }

    @FXML
    void salir(ActionEvent event) {

    }
    public void setPuntosUsuario(int puntos) {
        txtPuntosUsuario.setText(Integer.toString(puntos));
    }

    public void setPuntosRival(int puntos) {
        txtPuntosRival.setText(Integer.toString(puntos));
    }

}

