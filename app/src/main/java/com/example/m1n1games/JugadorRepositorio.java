package com.example.m1n1games;

import java.util.ArrayList;
import java.util.List;

public class JugadorRepositorio {

    static List<Jugador> jugadorlist = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Jugador> jugadorlist);
    }

    JugadorRepositorio(){
        jugadorlist.add(new Jugador("6", 9));

    }

    List<Jugador> obtener() {
        return jugadorlist;
    }

    static void insertar(Jugador jugador, Callback callback){
        jugadorlist.add(jugador);
        callback.cuandoFinalice(jugadorlist);
    }
}
