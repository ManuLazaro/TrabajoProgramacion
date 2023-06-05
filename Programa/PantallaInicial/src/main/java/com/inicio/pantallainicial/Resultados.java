package com.inicio.pantallainicial;

public class Resultados {
    private String nombreUsuarios;
    private String dificultad;
    private int resultado;

    public Resultados(String nombreUsuarios, String dificultad, int resultado) {
        this.nombreUsuarios = nombreUsuarios;
        this.dificultad = dificultad;
        this.resultado = resultado;
    }

    public String getNombreUsuarios() {
        return nombreUsuarios;
    }

    public void setNombreUsuarios(String nombreUsuarios) {
        this.nombreUsuarios = nombreUsuarios;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
