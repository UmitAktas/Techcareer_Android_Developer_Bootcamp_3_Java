package com.example.odev4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4.databinding.FragmentKayitGirisBinding;

public class KayitGirisFragment extends Fragment {

    private FragmentKayitGirisBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKayitGirisBinding.inflate(inflater, container, false);

        binding.buttonLogInKayitGiris.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.kayittanUygulamaIcineGecis);
        });

        return binding.getRoot();
    }
}