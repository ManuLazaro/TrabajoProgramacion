package com.inicio.pantallainicial;

public class Resultados {
    private String nombreUsuarios;
    private String dificultad;
    private int resultado;

    public Resultados(String dificultad, int resultado) {
        this.nombreUsuarios = DBManager.usuarioEstadisticas();
        this.dificultad = dificultad;
        this.resultado = resultado;
    }
}
