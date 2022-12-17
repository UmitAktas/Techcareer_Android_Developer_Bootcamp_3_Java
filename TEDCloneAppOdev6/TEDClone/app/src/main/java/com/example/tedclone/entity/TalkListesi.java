package com.example.tedclone.entity;

import java.io.Serializable;

public class TalkListesi implements Serializable {

    private String icerik;
    private String resimAdi;

    public TalkListesi(String icerik, String resimAdi) {
        this.icerik = icerik;
        this.resimAdi = resimAdi;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getResimAdi() {
        return resimAdi;
    }

    public void setResimAdi(String resimAdi) {
        this.resimAdi = resimAdi;
    }
}
