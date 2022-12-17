package com.example.tedclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.tedclone.databinding.BottomSayfaBinding;
import com.example.tedclone.databinding.FragmentPodcastBinding;

public class MainActivity extends AppCompatActivity {

    private BottomSayfaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BottomSayfaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragmentBottom);

        NavigationUI.setupWithNavController(binding.bottomNav, navHostFragment.getNavController());

    }
}