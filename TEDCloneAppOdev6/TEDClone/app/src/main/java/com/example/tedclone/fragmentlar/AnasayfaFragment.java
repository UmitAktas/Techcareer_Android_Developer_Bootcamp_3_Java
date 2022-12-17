package com.example.tedclone.fragmentlar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tedclone.R;
import com.example.tedclone.adapterlar.AnasayfaTalksAdapter;
import com.example.tedclone.databinding.FragmentAnasayfaBinding;
import com.example.tedclone.entity.TalkListesi;
import com.example.tedclone.entity.Talks;

import java.util.ArrayList;
import java.util.List;

public class AnasayfaFragment extends Fragment {

    private FragmentAnasayfaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);

        binding.toolbarAnasayfa.setTitle("TED");

        LinearLayoutManager layoutManager = new LinearLayoutManager(binding.getRoot().getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvAnasayfa.setLayoutManager(layoutManager);

        AnasayfaTalksAdapter adapter = new AnasayfaTalksAdapter(binding.getRoot().getContext(),talks());
        binding.rvAnasayfa.setAdapter(adapter);

        return binding.getRoot();
    }

    private List<Talks> talks(){
        List<Talks> talk = new ArrayList<>();

        Talks t1 = new Talks("", newOnTed(), "The best way to apologize (according to science)", "tedbuyuk", "News on TED");
        Talks t2 = new Talks("Newest", newset(), "", "", "");
        Talks t3 = new Talks("Trending", trending(), "", "", "");
        Talks t4 = new Talks("Editor's Picks", editor(), "", "", "");

        talk.add(t1);
        talk.add(t2);
        talk.add(t3);
        talk.add(t4);

        return talk;
    }

    private List<TalkListesi> newOnTed(){
        List<TalkListesi> talkL = new ArrayList<>();
        return  talkL;
    }

    private List<TalkListesi> newset(){
        List<TalkListesi> talkL = new ArrayList<>();

        TalkListesi t2 = new TalkListesi("How can we escape soaring energy bills? Stop using fossil fuels", "ted2");
        TalkListesi t3 = new TalkListesi("How great leaders take on uncertainty", "ted3");
        TalkListesi t4 = new TalkListesi("How Indigenous guardians protect the planet and humanity", "ted4");
        TalkListesi t5 = new TalkListesi("The Taj Mahal: A monument to eternal love", "ted5");
        talkL.add(t2);
        talkL.add(t3);
        talkL.add(t4);
        talkL.add(t5);

        return  talkL;
    }

    private List<TalkListesi> trending(){
        List<TalkListesi> talkL = new ArrayList<>();

        TalkListesi t6 = new TalkListesi("\"Go(l)d\" / \"Black Truck\"", "ted6");
        TalkListesi t7 = new TalkListesi("How millennials and Gen Z can invest in a better future", "ted7");
        TalkListesi t8 = new TalkListesi("\"Nice and Quiet\" / \"One Of These Days\"", "ted8");
        TalkListesi t1 = new TalkListesi("Are video calls the best we can do in the age of the metaverse?", "ted1");
        talkL.add(t6);
        talkL.add(t7);
        talkL.add(t8);
        talkL.add(t1);

        return  talkL;
    }

    private List<TalkListesi> editor(){
        List<TalkListesi> talkL = new ArrayList<>();

        TalkListesi t9 = new TalkListesi("How play helps a kid's brain grow", "ted9");
        TalkListesi t10 = new TalkListesi("A creative approach to community climate action", "ted10");
        TalkListesi t11 = new TalkListesi("5 hiring tips every company (and job seeker) should know", "ted11");
        TalkListesi t12 = new TalkListesi("The kingdom hidden in Brazil", "ted12");
        talkL.add(t9);
        talkL.add(t10);
        talkL.add(t11);
        talkL.add(t12);

        return  talkL;
    }

}