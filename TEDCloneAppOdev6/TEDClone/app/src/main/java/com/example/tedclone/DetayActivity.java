package com.example.tedclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.tedclone.adapterlar.PodcastDetayAdapter;
import com.example.tedclone.databinding.ActivityDetayBinding;
import com.example.tedclone.entity.OynatmaPodcastDetayAlti;
import com.example.tedclone.entity.PodcastDetay;

import java.util.ArrayList;
import java.util.List;

public class DetayActivity extends AppCompatActivity {

    private ActivityDetayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetayBinding.inflate(getLayoutInflater());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        PodcastDetayAdapter adapter = new PodcastDetayAdapter(this,podcastDetayList());

        binding.rvDetay.setAdapter(adapter);
        binding.rvDetay.setLayoutManager(layoutManager);

        setContentView(binding.getRoot());

    }

    private List<PodcastDetay> podcastDetayList(){

        PodcastDetay p = (PodcastDetay) getIntent().getSerializableExtra("nesne");

        List<PodcastDetay> detayListesi = new ArrayList<>();
        PodcastDetay p1 = new PodcastDetay(p.getPodcastResim(),p.getPodcastAdi(),p.getPodcastAciklama(),p.getPodcastHosted(),p.getHostedMeslek(),oynatmaListesi(), p.getPodcastTarih());
        detayListesi.add(p1);

        return detayListesi;
    }

    private List<OynatmaPodcastDetayAlti> oynatmaListesi(){

        List<OynatmaPodcastDetayAlti> oynatListe = new ArrayList<>();

        OynatmaPodcastDetayAlti o1 = new OynatmaPodcastDetayAlti("Super speed, magnetic levitation and the vision behind the hyperloop", "8:46 . ", "Nov 13, 2021", "play_resim");
        OynatmaPodcastDetayAlti o2 = new OynatmaPodcastDetayAlti("Tracking the whole world's carbon emission -- with satellites and AI", "11:20 . ", "Nov 12, 2021", "play_resim");
        OynatmaPodcastDetayAlti o3 = new OynatmaPodcastDetayAlti("The rise of predatory scams -- and how to prevent them", "13:53 . ", "Nov 11, 2021", "play_resim");
        OynatmaPodcastDetayAlti o4 = new OynatmaPodcastDetayAlti("How your brain invents your \"self\"", "23:10 . ", "Nov 10, 2021", "play_resim");

        oynatListe.add(o1);
        oynatListe.add(o2);
        oynatListe.add(o3);
        oynatListe.add(o4);

        return oynatListe;
    }

}