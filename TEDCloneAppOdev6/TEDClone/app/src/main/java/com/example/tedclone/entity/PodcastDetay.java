package com.example.tedclone.entity;

import java.io.Serializable;
import java.util.List;

public class PodcastDetay implements Serializable {
    private String podcastResim;
    private String podcastAdi;
    private String podcastAciklama;
    private String podcastHosted;
    private String hostedMeslek;
    private List<OynatmaPodcastDetayAlti> oynatmaPodcastDetayAltis;
    private String podcastTarih;

    public PodcastDetay(String podcastResim, String podcastAdi, String podcastAciklama, String podcastHosted, String hostedMeslek, List<OynatmaPodcastDetayAlti> oynatmaPodcastDetayAltis, String podcastTarih) {
        this.podcastResim = podcastResim;
        this.podcastAdi = podcastAdi;
        this.podcastAciklama = podcastAciklama;
        this.podcastHosted = podcastHosted;
        this.hostedMeslek = hostedMeslek;
        this.oynatmaPodcastDetayAltis = oynatmaPodcastDetayAltis;
        this.podcastTarih = podcastTarih;
    }

    public String getPodcastResim() {
        return podcastResim;
    }

    public void setPodcastResim(String podcastResim) {
        this.podcastResim = podcastResim;
    }

    public String getPodcastAdi() {
        return podcastAdi;
    }

    public void setPodcastAdi(String podcastAdi) {
        this.podcastAdi = podcastAdi;
    }

    public String getPodcastAciklama() {
        return podcastAciklama;
    }

    public void setPodcastAciklama(String podcastAciklama) {
        this.podcastAciklama = podcastAciklama;
    }

    public String getPodcastHosted() {
        return podcastHosted;
    }

    public void setPodcastHosted(String podcastHosted) {
        this.podcastHosted = podcastHosted;
    }

    public String getHostedMeslek() {
        return hostedMeslek;
    }

    public void setHostedMeslek(String hostedMeslek) {
        this.hostedMeslek = hostedMeslek;
    }

    public List<OynatmaPodcastDetayAlti> getOynatmaPodcastDetayAltis() {
        return oynatmaPodcastDetayAltis;
    }

    public void setOynatmaPodcastDetayAltis(List<OynatmaPodcastDetayAlti> oynatmaPodcastDetayAltis) {
        this.oynatmaPodcastDetayAltis = oynatmaPodcastDetayAltis;
    }

    public String getPodcastTarih() {
        return podcastTarih;
    }

    public void setPodcastTarih(String podcastTarih) {
        this.podcastTarih = podcastTarih;
    }
}
