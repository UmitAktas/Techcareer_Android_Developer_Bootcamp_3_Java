package com.example.odev4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4.databinding.FragmentGirisYapBinding;

public class GirisYapFragment extends Fragment {

    private FragmentGirisYapBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGirisYapBinding.inflate(inflater, container, false);

        binding.buttonLogInGiris.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.giristenUygulamaIcineGecis);
        });

        return binding.getRoot();
    }
}