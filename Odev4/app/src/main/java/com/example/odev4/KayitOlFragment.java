package com.example.odev4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4.databinding.FragmentKayitOlBinding;

public class KayitOlFragment extends Fragment {

    private FragmentKayitOlBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKayitOlBinding.inflate(inflater, container, false);

        binding.buttonSignUpKayit.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.kayitGiriseGecis);
        });

        return binding.getRoot();
    }
}