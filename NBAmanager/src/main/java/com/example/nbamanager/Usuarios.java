package com.example.nbamanager;

public class Usuarios {
    private String dificultad;
    private String nombre;
    private String resultado;

    public Usuarios( String nombre, String resultado,String dificultad) {
        this.nombre = nombre;
        this.resultado = resultado;
        this.dificultad = dificultad;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
