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
public class SepetViewModel extends ViewModel {
    private YemeklerDaoRepository yrepo;
    public MutableLiveData<List<SepetYemekler>> sepetYemeklerListesi = new MutableLiveData<>();

    @Inject
    public SepetViewModel(YemeklerDaoRepository yrepo) {
        this.yrepo = yrepo;
        this.sepetYemeklerListesi = yrepo.getSepetYemeklerListesi();
        sepettekiYemekleriGetir(yrepo.kullaniciAdi());
    }

    public void sepettekiYemekleriGetir(String kullanici_adi){
        yrepo.sepettekiYemekleriGetir(kullanici_adi);
    }

    public void yemekResimleriniGoster(String yemek_resim_adi, ImageView imageView){
        yrepo.yemekResimleriniGoster(yemek_resim_adi, imageView);
    }

    public void sepettenSil(int sepet_yemek_id, String kullanici_adi){
        yrepo.sepettenYemekSil(sepet_yemek_id, kullanici_adi);
    }

    public String sepetTutari(){
        return yrepo.sepetTutari();
    }

    public String kullaniciAdi(){
        return yrepo.kullaniciAdi();
    }

}
