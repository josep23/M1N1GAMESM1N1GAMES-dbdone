package com.example.m1n1games;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m1n1games.databinding.FragmentLightsOutBinding;
import com.example.m1n1games.databinding.FragmentMenuLightOutBinding;
import com.thekhaeng.pushdownanim.PushDownAnim;


public class MenuLightOutFragment extends Fragment {
    NavController navController;
    private FragmentMenuLightOutBinding binding;
    private Dialog dialog;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentMenuLightOutBinding.inflate(inflater,container,false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        dialog = new Dialog(getActivity());
        PushDownAnim.setPushDownAnimTo(binding.button4).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_menuLightOutFragment_to_comojugarfragment);
                    }
                });
        PushDownAnim.setPushDownAnimTo(binding.button2).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_menuLightOutFragment_to_lightsOut);
                    }
                });
        PushDownAnim.setPushDownAnimTo(binding.botonsalir).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_menuLightOutFragment_to_menu);
                    }
                });
        PushDownAnim.setPushDownAnimTo(binding.botonranking).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_menuLightOutFragment_to_ranking);
                    }
                });
        PushDownAnim.setPushDownAnimTo(binding.button3).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_menuLightOutFragment_to_lightsOut);
                    }
                });
    }
}