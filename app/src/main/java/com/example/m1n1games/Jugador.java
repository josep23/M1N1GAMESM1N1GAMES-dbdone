package com.example.m1n1games;

public class Jugador {
    public String nivel;
    public Integer movimientos;

    public Jugador(String nivel, Integer movimientos) {
        this.nivel = nivel;
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nivel='" + nivel + '\'' +
                ", movimientos=" + movimientos +
                '}';
    }
}
