package com.example.tedclone.entity;

public class OynatmaPodcastDetayAlti {
    private String icerik;
    private String sure;
    private String tarih;
    private String resimAdi;

    public OynatmaPodcastDetayAlti(String icerik, String sure, String tarih, String resimAdi) {
        this.icerik = icerik;
        this.sure = sure;
        this.tarih = tarih;
        this.resimAdi = resimAdi;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getSure() {
        return sure;
    }

    public void setSure(String sure) {
        this.sure = sure;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getResimAdi() {
        return resimAdi;
    }

    public void setResimAdi(String resimAdi) {
        this.resimAdi = resimAdi;
    }
}
