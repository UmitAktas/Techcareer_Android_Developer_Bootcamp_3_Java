package com.example.doydoy.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doydoy.R;
import com.example.doydoy.data.entity.SepetYemekler;
import com.example.doydoy.databinding.FragmentSepetBinding;
import com.example.doydoy.ui.adapter.SepetAdapter;
import com.example.doydoy.ui.viewmodel.SepetViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SepetFragment extends Fragment {

    private FragmentSepetBinding binding;
    private SepetViewModel viewModel;
    private  SepetYemekler sepeteGelenYemek;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sepet, container, false);

        binding.setFragment(this);

        /*SepetFragmentArgs bundle = SepetFragmentArgs.fromBundle(getArguments());
        sepeteGelenYemek = bundle.getSepetYemek();*/

        sepetTutariYazdir(binding.textViewSepetFiyat);

        try {
            SepetFragmentArgs bundle = SepetFragmentArgs.fromBundle(getArguments());
            sepeteGelenYemek = bundle.getSepetYemek();
        }catch (Exception e){
            SepetYemekler bosYemek = new SepetYemekler(0,"","",0,0,"");
            sepeteGelenYemek = bosYemek;
        }


        viewModel.sepettekiYemekleriGetir(sepeteGelenYemek.getKullanici_adi());

        viewModel.sepetYemeklerListesi.observe(getViewLifecycleOwner(), yemeklerListesi -> {
            SepetAdapter adapter = new SepetAdapter(requireContext(), yemeklerListesi, viewModel);
            binding.setAdapter(adapter);
        });

        return binding.getRoot();
    }

    public void sepetTutariYazdir(TextView textView){
        textView.setText(viewModel.sepetTutari() +"₺");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SepetViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.sepetYemeklerListesi.observe(getViewLifecycleOwner(), yemeklerListesi -> {
            SepetAdapter adapter = new SepetAdapter(requireContext(), yemeklerListesi, viewModel);
            binding.setAdapter(adapter);
        });
    }
}