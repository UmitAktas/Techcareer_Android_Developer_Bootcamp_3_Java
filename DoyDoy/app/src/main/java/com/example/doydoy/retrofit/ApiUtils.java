package com.example.doydoy.retrofit;

public class ApiUtils {

    public static final String BASE_URL = "http://kasimadalan.pe.hu/yemekler/";

    public static YemeklerDao getYemeklerDao(){
        return RetrofitClient.getClient(BASE_URL).create(YemeklerDao.class);
    }

}
