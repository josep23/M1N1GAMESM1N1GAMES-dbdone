package com.example.m1n1games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.m1n1games.databinding.FragmentLightsOutBinding;
import com.example.m1n1games.databinding.FragmentMenuBinding;
import com.example.m1n1games.databinding.FragmentMenuLightOutBinding;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Menu extends Fragment {
    NavController navController;
    private FragmentMenuBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentMenuBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        PushDownAnim.setPushDownAnimTo(binding.botonsalir).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                });
        PushDownAnim.setPushDownAnimTo(binding.botonlightsout).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_menu_to_menuLightOutFragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo(binding.botonconecta4).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_menu_to_problemastecniosFragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo(binding.botondamas).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_menu_to_problemastecniosFragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo(binding.botonranking).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_menu_to_ranking);
                    }
                });
    }
}