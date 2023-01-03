package com.example.doydoy.ui.viewmodel;

import android.widget.ImageView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.doydoy.data.entity.Yemekler;
import com.example.doydoy.data.repo.YemeklerDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class YemeklerViewModel extends ViewModel {
    private YemeklerDaoRepository yrepo;
    public MutableLiveData<List<Yemekler>> yemeklerListesi = new MutableLiveData<>();

    @Inject
    public YemeklerViewModel(YemeklerDaoRepository yrepo){
        this.yrepo = yrepo;
        yemeklerListesi = yrepo.getYemeklerListesi();
        yemekleriYukle();
    }

    public void yemekleriYukle(){
        yrepo.yemekleriYukle();
    }

    public void yemekResimleriniGoster(String yemek_resim_adi, ImageView imageView){
        yrepo.yemekResimleriniGoster(yemek_resim_adi, imageView);
    }

    public void ara(String aramaKelimesi){
        yrepo.ara(aramaKelimesi);
    }

    public void yemeklerKategori(String yemek_adi, String kategori_adi){
        yrepo.yemeklerKategori(yemek_adi, kategori_adi);
    }

}
