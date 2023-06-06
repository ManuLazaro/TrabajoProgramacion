package com.example.nbamanager;


import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private ArrayList<Jugadores> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugadores jugador) {
        jugadores.add(jugador);
    }

    public ArrayList<Jugadores> obtenerJugadores() {
        return jugadores;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setJugadores(ArrayList<Jugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Jugadores> getJugadores() {
        return jugadores;
    }
}

