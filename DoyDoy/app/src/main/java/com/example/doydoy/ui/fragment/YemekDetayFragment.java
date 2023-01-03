package com.example.doydoy.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doydoy.R;
import com.example.doydoy.data.entity.SepetYemekler;
import com.example.doydoy.data.entity.Yemekler;
import com.example.doydoy.databinding.FragmentYemekDetayBinding;
import com.example.doydoy.ui.viewmodel.YemeklerDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class YemekDetayFragment extends Fragment {
    private FragmentYemekDetayBinding binding;
    private YemeklerDetayViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_detay, container, false);

        binding.setDetayFragment(this);

        YemekDetayFragmentArgs bundle = YemekDetayFragmentArgs.fromBundle(getArguments());
        Yemekler gelenUrun = bundle.getYemek();
        SepetYemekler sepeteAtilacakYemek = new SepetYemekler(gelenUrun.getYemek_id(), gelenUrun.getYemek_adi(), gelenUrun.getYemek_resim_adi(),gelenUrun.getYemek_fiyat(),this.yemek_siparis_adet, viewModel.kullaniciAdi());
        binding.setYemekNesnesi(sepeteAtilacakYemek);

        viewModel.yemekResimleriniGoster(gelenUrun.getYemek_resim_adi(), binding.imageViewUrun);

        return binding.getRoot();
    }

    private int yemek_siparis_adet = 0;
    public void azalt(TextView textView){
        if (yemek_siparis_adet > 0){
            yemek_siparis_adet--;
            textView.setText(Integer.toString(yemek_siparis_adet));
        }
    }

    public void arttir(TextView textView){
        yemek_siparis_adet++;
        textView.setText(Integer.toString(yemek_siparis_adet));
    }

    public void sepeteEkle(int yemek_id, String yemek_adi, String yemek_resim_adi, int yemek_fiyat, String kullanici_adi){
        YemekDetayFragmentArgs bundle = YemekDetayFragmentArgs.fromBundle(getArguments());
        Yemekler gelenUrun = bundle.getYemek();
        SepetYemekler sepeteAtilacakYemek = new SepetYemekler(gelenUrun.getYemek_id(), gelenUrun.getYemek_adi(), gelenUrun.getYemek_resim_adi(),gelenUrun.getYemek_fiyat(),this.yemek_siparis_adet, viewModel.kullaniciAdi());

        if (yemek_siparis_adet > 0){
            viewModel.sepeteYemekEkle(sepeteAtilacakYemek.getSepet_yemek_id(), sepeteAtilacakYemek.getYemek_adi(), sepeteAtilacakYemek.getYemek_resim_adi(), sepeteAtilacakYemek.getYemek_fiyat(), sepeteAtilacakYemek.getYemek_siparis_adet(), sepeteAtilacakYemek.getKullanici_adi());

            YemekDetayFragmentDirections.SepetFragmentaGecis gecis = YemekDetayFragmentDirections.sepetFragmentaGecis(sepeteAtilacakYemek);
            Navigation.findNavController(binding.getRoot()).navigate(gecis);
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YemeklerDetayViewModel.class);
    }
}