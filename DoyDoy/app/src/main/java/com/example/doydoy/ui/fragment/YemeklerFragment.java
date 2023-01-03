package com.example.doydoy.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.doydoy.R;
import com.example.doydoy.data.entity.SepetYemekler;
import com.example.doydoy.databinding.FragmentYemeklerBinding;
import com.example.doydoy.ui.adapter.YemeklerAdapter;
import com.example.doydoy.ui.viewmodel.YemeklerViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class YemeklerFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentYemeklerBinding binding;
    private YemeklerViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_yemekler, container, false);

        binding.setFrag(this);

        viewModel.yemeklerListesi.observe(getViewLifecycleOwner(), yemeklerListesi -> {
            YemeklerAdapter adapter = new YemeklerAdapter(requireContext(), yemeklerListesi, viewModel);
            binding.setYemeklerAdapter(adapter);
        });

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu);

                MenuItem item = menu.findItem(R.id.action_ara);
                item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
                SearchView sv = new SearchView(getActivity());
                sv.setOnQueryTextListener(YemeklerFragment.this);
                item.setActionView(sv);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        /*binding.imageViewSepete.setOnClickListener(view -> {
            SepetYemekler bosYemek = new SepetYemekler(0,"","",0,0,"");
            YemeklerFragmentDirections.AnasayfadanSepetFragmentaGecis gecis = YemeklerFragmentDirections.anasayfadanSepetFragmentaGecis(bosYemek);
            Navigation.findNavController(view).navigate(gecis);
        });*/

        return binding.getRoot();
    }

    public void sepeteGecis(View view){
        SepetYemekler bosYemek = new SepetYemekler(0,"","",0,0,"");
        YemeklerFragmentDirections.AnasayfadanSepetFragmentaGecis gecis = YemeklerFragmentDirections.anasayfadanSepetFragmentaGecis(bosYemek);
        Navigation.findNavController(view).navigate(gecis);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YemeklerViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.yemeklerListesi.observe(getViewLifecycleOwner(), yemeklerListesi -> {
            YemeklerAdapter adapter = new YemeklerAdapter(requireContext(), yemeklerListesi, viewModel);
            binding.setYemeklerAdapter(adapter);
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.ara(query);
        viewModel.yemekleriYukle();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.ara(newText);
        viewModel.yemekleriYukle();
        return true;
    }
}