package com.example.doydoy.data.repo;

import android.util.Log;
import android.widget.ImageView;

import androidx.lifecycle.MutableLiveData;

import com.example.doydoy.data.entity.SepetYemekler;
import com.example.doydoy.data.entity.SepetYemeklerCevap;
import com.example.doydoy.data.entity.Yemekler;
import com.example.doydoy.data.entity.YemeklerCevap;
import com.example.doydoy.retrofit.YemeklerDao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YemeklerDaoRepository {

    private MutableLiveData<List<Yemekler>> yemeklerListesi;
    private MutableLiveData<List<SepetYemekler>> sepetYemeklerListesi;
    private YemeklerDao ydao;
    private SepetYemekler gelenYemek;
    private List<SepetYemekler> gelenYemekler;
    private List<SepetYemekler> liste;
    private int toplam = 0;
    private int tutar = 0;

    public YemeklerDaoRepository(YemeklerDao ydao) {
        this.yemeklerListesi = new MutableLiveData();
        this.sepetYemeklerListesi = new MutableLiveData();
        this.ydao = ydao;
        this.gelenYemekler = new ArrayList<>();
    }

    public MutableLiveData<List<Yemekler>> getYemeklerListesi(){
        return yemeklerListesi;
    }
    public MutableLiveData<List<SepetYemekler>> getSepetYemeklerListesi(){
        return sepetYemeklerListesi;
    }

    public void yemekleriYukle(){
        ydao.yemekleriYukle().enqueue(new Callback<YemeklerCevap>() {
            @Override
            public void onResponse(Call<YemeklerCevap> call, Response<YemeklerCevap> response) {
                List<Yemekler> liste = response.body().getYemekler();
                yemeklerListesi.setValue(liste);
            }

            @Override
            public void onFailure(Call<YemeklerCevap> call, Throwable t) {

            }
        });
    }

    public void ara(String aramaKelimesi){
        ydao.ara(aramaKelimesi).enqueue(new Callback<YemeklerCevap>() {
            @Override
            public void onResponse(Call<YemeklerCevap> call, Response<YemeklerCevap> response) {
                List<Yemekler> liste = response.body().getYemekler();
                yemeklerListesi.setValue(liste);
            }

            @Override
            public void onFailure(Call<YemeklerCevap> call, Throwable t) {

            }
        });
    }

    public void sepeteYemekEkle(int yemek_id, String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi){
        gelenYemek = new SepetYemekler(yemek_id, yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi);
        if(gelenYemek.getYemek_adi() != ""){
            gelenYemekler.add(gelenYemek);
        }
        ydao.sepeteYemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi).enqueue(new Callback<SepetYemeklerCevap>() {
            @Override
            public void onResponse(Call<SepetYemeklerCevap> call, Response<SepetYemeklerCevap> response) {

            }

            @Override
            public void onFailure(Call<SepetYemeklerCevap> call, Throwable t) {

            }
        });
    }

    public void sepettekiYemekleriGetir(String kullanici_adi){
        ydao.sepettekiYemekleriGetir(kullanici_adi).enqueue(new Callback<SepetYemeklerCevap>() {
            @Override
            public void onResponse(Call<SepetYemeklerCevap> call, Response<SepetYemeklerCevap> response) {
                liste = response.body().getSepetYemekler();
                sepetYemeklerListesi.setValue(liste);
            }

            @Override
            public void onFailure(Call<SepetYemeklerCevap> call, Throwable t) {

            }
        });
    }
    //SİLİNEN YEMEĞİ GELENYEMEKLERDEN SİLMEYE ÇALIŞIYOM
    public void sepettenYemekSil(int sepet_yemek_id, String kullanici_adi){
        ydao.sepettenYemekSil(sepet_yemek_id, kullanici_adi).enqueue(new Callback<SepetYemeklerCevap>() {
            @Override
            public void onResponse(Call<SepetYemeklerCevap> call, Response<SepetYemeklerCevap> response) {
                sepettekiYemekleriGetir(kullanici_adi);

            }

            @Override
            public void onFailure(Call<SepetYemeklerCevap> call, Throwable t) {

            }
        });
    }

    public String sepetTutari(){
        for (int i = 0; i < gelenYemekler.size(); i++){
            tutar = (gelenYemekler.get(i).getYemek_fiyat() * gelenYemekler.get(i).getYemek_siparis_adet());
        }
        toplam += tutar;
        return String.valueOf(toplam);
    }

    public void yemekResimleriniGoster(String yemek_resim_adi, ImageView imageView){
        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + yemek_resim_adi;
        Picasso.get().load(url).into(imageView);
    }

    public String kullaniciAdi(){
        String kullanici_adi = "umitaktas";
        return kullanici_adi;
    }

    public void yemeklerKategori(String yemek_adi, String kategori_adi){
        String[] icecekler = {"ayran.png", "fanta.png", "kahve.png", "su.png"};
        String[] tatlilar = {"baklava.png", "kadayif.png", "sutlac.png", "tiramisu.png"};
        String[] yemekler = {"izgarasomon.png", "izgaratavuk.png", "kofte.png", "lazanya.png", "makarna.png", "pizza.png"};

        for (int i = 0; i < 14; i++){
            if (yemek_adi == icecekler[i]){
                kategori_adi = "İçecekler";
            }
            else if (yemek_adi == tatlilar[i]){
                kategori_adi = "Tatlılar";
            }
            else if (yemek_adi == yemekler[i]){
                kategori_adi = "Yemekler";
            }
        }
    }

}
