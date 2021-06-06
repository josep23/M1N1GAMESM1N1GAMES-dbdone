package com.example.m1n1games;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m1n1games.databinding.FragmentRankingBinding;
import com.example.m1n1games.databinding.ViewholderJugadorBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.List;

import static com.example.m1n1games.JugadorRepositorio.jugadorlist;


public class Ranking extends Fragment {
    NavController navController;
    private FragmentRankingBinding binding;
    private JugadorRepositorio jugadorRepositorio;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRankingBinding.inflate(inflater, container, false)).getRoot();

    }
    class JugadorViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderJugadorBinding binding;
        public JugadorViewHolder(ViewholderJugadorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        JugadorViewModel jugadorViewModel = new ViewModelProvider(requireActivity()).get(JugadorViewModel.class);
        // Crea aqui el objeto JugadoresAdaptador
        JugadoresAdaptador jugadoresAdaptador = new JugadoresAdaptador();
        // establece el adaptador al recyclerview (setAdapter)
        binding.recyclerView.setAdapter(jugadoresAdaptador);
        // obtener el array de Jugadores, y pasarselo al Adaptador
        JugadorViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Jugador>>() {
            @Override
            public void onChanged(List<Jugador> jugadorList) {
                jugadoresAdaptador.establecerLista(jugadorList);
            }
        });
        // es una fotografia de la base de datos (de la coleccion o lo que estes consultando)
        // cada document es un jugador

        //FirebaseFirestore.getInstance().collection("Jugador").orderBy("nivel").addSnapshotListener((value, error) -> {
          //  for (DocumentSnapshot documentSnapshot : value) {
            //    jugadorlist.add(documentSnapshot.toObject(Jugador.class));
            //}
            //jugadorlist.forEach(jugador -> System.out.println(jugador));
        //});
        FirebaseFirestore.getInstance().collection("Jugador").orderBy("nivel").addSnapshotListener((value, error) -> {
            jugadorlist.clear();
            value.forEach(document ->{
                jugadorlist.add(new Jugador(
                        document.getString("nivel"),
                        Math.toIntExact((Long) document.get("movimientos"))));
            });
            jugadoresAdaptador.notifyDataSetChanged();
        });

        PushDownAnim.setPushDownAnimTo(binding.botonsalir).setScale(PushDownAnim.MODE_SCALE, 0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(v -> navController.navigate(R.id.action_ranking_to_menu));
    }

    // crea aqui la clase JugadoresAdaptador
    class JugadoresAdaptador extends RecyclerView.Adapter<JugadorViewHolder> {

        List<Jugador> jugadorList;

        @NonNull
        // el metodo onCreateViewHolder solo tienes que cambiar: 1 el tipo de retorno
        @Override
        public JugadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new JugadorViewHolder(ViewholderJugadorBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull JugadorViewHolder holder, int position) {

            Jugador jugador = jugadorList.get(position);

            holder.binding.Nivel.setText(jugador.nivel);
            holder.binding.Movimiento.setText(jugador.movimientos.toString());
        }

        @Override
        public int getItemCount() {
            return jugadorList != null ? jugadorList.size() : 0;
        }

        public void establecerLista(List<Jugador> jugadorList){
            this.jugadorList = jugadorList;
            notifyDataSetChanged();
        }
    }

    // recuerda que si el .xml se llama por ejemplo: viewholder_jugador.xml entonces la clase de "binding"
    // se llamara ViewholderJugadorBinding (es decir, sin _, en mayusculas y con el binding al final)

    // XML: tienes que añadir el <RecyclerView> en la pantalla esta
    // Tienes que crear el fichero viewholder_jugador.xml con los dos textviews (nivel, jugadas)
}