package com.example.doydoy.retrofit;

import com.example.doydoy.data.entity.SepetYemeklerCevap;
import com.example.doydoy.data.entity.YemeklerCevap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/yemekler/ -> Base URL
    //tumYemekleriGetir.php -> Webservice URL
    //GET: Web servise veri gönderilmiyorsa.
    //POST: Eğer web servise veri gönderiliyorsa.

    @GET("tumYemekleriGetir.php")
    Call<YemeklerCevap> yemekleriYukle();

    @POST("tumYemekleriGetir.php")
    @FormUrlEncoded
    Call<YemeklerCevap> ara(@Field("yemek_adi") String aramaKelimesi);

    @POST("sepeteYemekEkle.php")
    @FormUrlEncoded
    Call<SepetYemeklerCevap> sepeteYemekEkle(@Field("yemek_adi") String yemek_adi, @Field("yemek_resim_adi") String yemek_resim_adi,
                                    @Field("yemek_fiyat") int yemek_fiyat, @Field("yemek_siparis_adet") int yemek_siparis_adet,
                                    @Field("kullanici_adi") String kullanici_adi);

    @POST("sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    Call<SepetYemeklerCevap> sepettekiYemekleriGetir(@Field("kullanici_adi") String kullanici_adi);

    @POST("sepettenYemekSil.php")
    @FormUrlEncoded
    Call<SepetYemeklerCevap> sepettenYemekSil(@Field("sepet_yemek_id") int sepet_yemek_id, @Field("kullanici_adi") String kullanici_adi);

}
