package com.example.nbamanager;

public class Jugadores {
    private String nombre;
    private int tiro;
    private int destreza;
    private int defensa;
    private String posicion;

    public Jugadores(String n, int t, int D, int d, String p){
        this.nombre=n;
        this.tiro=t;
        this.destreza=D;
        this.defensa=d;
        this.posicion=p;
    }


    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String n){
        this.nombre=n;
    }

    public int getTiro() {
        return tiro;
    }

    public void setTiro(int tiro) {
        this.tiro = tiro;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void mostrarJugador(){
        System.out.println("Jugador con nombre "+this.nombre+" que juega en la posicion "+this.posicion+"Con estas estadisticas: /n"+" tiro:"+tiro+" destreza:"+destreza+" defensa:"+defensa);
    }
    public String toString() {
        return nombre; // Devuelve el nombre del jugador como representación en cadena
    }

}