package com.example.doydoy.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SepetYemeklerCevap {
    @SerializedName("sepet_yemekler")
    private List<SepetYemekler> sepetYemekler;
    @SerializedName("success")
    private int success;

    public SepetYemeklerCevap() {
    }

    public SepetYemeklerCevap(List<SepetYemekler> sepetYemekler, int success) {
        this.sepetYemekler = sepetYemekler;
        this.success = success;
    }

    public List<SepetYemekler> getSepetYemekler() {
        return sepetYemekler;
    }

    public void setSepetYemekler(List<SepetYemekler> sepetYemekler) {
        this.sepetYemekler = sepetYemekler;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
