package com.example.m1n1games;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import java.util.List;

public class JugadorViewModel extends AndroidViewModel {
    JugadorRepositorio jugadorRepositorio;

    static MutableLiveData<List<Jugador>> listJugadoresMutableLiveData = new MutableLiveData<>();

    public JugadorViewModel(@NonNull Application application) {
        super(application);

        jugadorRepositorio = new JugadorRepositorio();

        listJugadoresMutableLiveData.setValue(jugadorRepositorio.obtener());
    }
    static MutableLiveData<List<Jugador>> obtener(){
        return listJugadoresMutableLiveData;
    }

}
