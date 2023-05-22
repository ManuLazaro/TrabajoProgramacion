package com.inicio.pantallainicial;

public class Jugadores {
    private String nombre;
    private String tiro;
    private String destreza;
    private String defensa;
    private String posicion;

    public Jugadores(String n, String t, String D, String d, String p){
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

    public String getTiro() {
        return tiro;
    }

    public void setTiro(String tiro) {
        this.tiro = tiro;
    }

    public String getDestreza() {
        return destreza;
    }

    public void setDestreza(String destreza) {
        this.destreza = destreza;
    }

    public String getDefensa() {
        return defensa;
    }

    public void setDefensa(String defensa) {
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
}