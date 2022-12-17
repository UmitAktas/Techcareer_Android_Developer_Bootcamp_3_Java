package com.example.tedclone.entity;

import java.io.Serializable;
import java.util.List;

public class Talks implements Serializable {
    private String baslik;
    private List<TalkListesi> talkListesi;
    private String ted1Icerik;
    private String ted1Resim;
    private String ted1Baslik;

    public Talks(String baslik, List<TalkListesi> talkListesi, String ted1Icerik, String ted1Resim, String ted1Baslik) {
        this.baslik = baslik;
        this.talkListesi = talkListesi;
        this.ted1Icerik = ted1Icerik;
        this.ted1Resim = ted1Resim;
        this.ted1Baslik = ted1Baslik;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public List<TalkListesi> getTalkListesi() {
        return talkListesi;
    }

    public void setTalkListesi(List<TalkListesi> talkListesi) {
        this.talkListesi = talkListesi;
    }

    public String getTed1Baslik() {
        return ted1Baslik;
    }

    public void setTed1Baslik(String ted1Baslik) {
        this.ted1Baslik = ted1Baslik;
    }

    public String getTed1Icerik() {
        return ted1Icerik;
    }

    public void setTed1Icerik(String ted1Icerik) {
        this.ted1Icerik = ted1Icerik;
    }

    public String getTed1Resim() {
        return ted1Resim;
    }

    public void setTed1Resim(String ted1Resim) {
        this.ted1Resim = ted1Resim;
    }
}
