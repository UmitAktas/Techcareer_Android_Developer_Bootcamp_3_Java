package com.example.doydoy.ui.viewmodel;

import android.widget.ImageView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.doydoy.data.entity.SepetYemekler;
import com.example.doydoy.data.repo.YemeklerDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class YemeklerDetayViewModel extends ViewModel {
    private YemeklerDaoRepository yrepo;
    public MutableLiveData<List<SepetYemekler>> sepetYemeklerListesi = new MutableLiveData<>();

    @Inject
    public YemeklerDetayViewModel(YemeklerDaoRepository yrepo) {
        this.yrepo = yrepo;
        this.sepetYemeklerListesi = yrepo.getSepetYemeklerListesi();
    }

    public void sepeteYemekEkle(int yemek_id, String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi){
        yrepo.sepeteYemekEkle(yemek_id,yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi);
    }

    public void sepettekiYemekleriGetir(String kullanici_adi){
        yrepo.sepettekiYemekleriGetir(kullanici_adi);
    }

    public void yemekResimleriniGoster(String yemek_resim_adi, ImageView imageView){
        yrepo.yemekResimleriniGoster(yemek_resim_adi, imageView);
    }

    public String kullaniciAdi(){
        return yrepo.kullaniciAdi();
    }

}
