package com.example.tedclone.fragmentlar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tedclone.adapterlar.PodcastAdapter;
import com.example.tedclone.databinding.FragmentPodcastBinding;
import com.example.tedclone.entity.OynatmaPodcastDetayAlti;
import com.example.tedclone.entity.PodcastDetay;

import java.util.ArrayList;
import java.util.List;

public class PodcastFragment extends Fragment {

    private FragmentPodcastBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPodcastBinding.inflate(inflater, container, false);

        binding.toolbarPodcast.setTitle("TED Podcast");
        binding.rvPodcast.setLayoutManager( new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        ArrayList<PodcastDetay> podcastListeleri = new ArrayList<>();
        PodcastDetay p1 = new PodcastDetay("podcast1", "TED Talks Daily", "Every weekday, join journalist Elise Hu for thought-provoking ideas given by the world's leading thinkers and creators. With TED Talks Daily, find some space in your day to change your perspectives, ignite your curiosity, and learn something new.",
                "Hosted by: Elise Hu", "Broadcast Journalist", oynatmaListesi(), "Today");
        PodcastDetay p2 = new PodcastDetay("podcast2", "Re: Thinking with Adam Grant", "As an organizational psychologist, Adam Grant believes that great minds don’t think alike; they challenge each other to think differently. In his new show, he has lively discussions and debates with some of the world’s most interesting thinkers, creators, achievers, and leaders to find out what makes them tick.",
                "Hosted by: Adam Grant", "Organizational Psychologist", oynatmaListesi(), "Yesterday");
        PodcastDetay p3 = new PodcastDetay("podcast3", "Outrage + Optimism", "Face the climate crisis head on, but understand that we have the power to solve this. From former UN Chief Christiana Figueres and the team who brought you the Paris Agreement, this podcast about issues and politics will inform you, inspire you and help you realize that this is the most exciting time in history to be alive.",
                "Hosted by: Christiana Figueres, Tom Rivett-Carnac and Paul Dickinson", "Stubborn optimist and nonprofit and political strategists", oynatmaListesi(), "Dec 1, 2022");
        PodcastDetay p4 = new PodcastDetay("podcast4", "Am I Normal? With Mona Chalabi", "We all want to know if we’re normal—do I have enough friends? Should it take me this long to get over my ex? Should I move or stay where I am? Endlessly curious data journalist Mona Chalabi NEEDS to know, and she’s ready to dive into the numbers to get some answers.",
                "Hosted by: Mona Chalabi", "Data Journalist", oynatmaListesi(), "Nov 2, 2022");
        PodcastDetay p5 = new PodcastDetay("podcast5", "After Hours", "A podcast at the intersection of business & culture. Listen in as Harvard professors Youngme Moon, Felix Oberholzer-Gee, and Mihir Desai, catch up after work and offer an insightful look at current events.",
                "","", oynatmaListesi(), "October 3, 2022");
        PodcastDetay p6 = new PodcastDetay("podcast6", "TED Radio Hour", "Can we preserve our humanity in the digital age? Where does creativity come from? And what's the secret to living longer? Manoush Zomorodi explores big ideas through TED Talks and original interviews, inspiring us to learn more about the world, our communities, and most importantly, ourselves.",
                "Hosted by: Manoush Zomorodi", "Journalist and Author", oynatmaListesi(), "Sept 4, 2022");
        PodcastDetay p7 = new PodcastDetay("podcast7", "Far Flung", "Far Flung will take you on a journey across the globe in search of the world's most surprising ideas. It’s not a travel show, exactly, but a deep dive into the ideas that shape a certain spot on the globe.",
                "Hosted by: Saleem Reshamwala", "Journalist and Filmmaker", oynatmaListesi(), "Aug 5, 2022");
        PodcastDetay p8 = new PodcastDetay("podcast8", "The TED Interview", "Join writer and podcaster Steven Johnson as he sits down with some of the world’s most interesting people to wrestle with the most provocative and powerful ideas of our time.",
                "Hosted by: Steven Johnson", "Writer", oynatmaListesi(), "July 6, 2022");

        podcastListeleri.add(p1);
        podcastListeleri.add(p2);
        podcastListeleri.add(p3);
        podcastListeleri.add(p4);
        podcastListeleri.add(p5);
        podcastListeleri.add(p6);
        podcastListeleri.add(p7);
        podcastListeleri.add(p8);

        PodcastAdapter adapter = new PodcastAdapter(binding.getRoot().getContext(), podcastListeleri);
        binding.rvPodcast.setAdapter(adapter);

        return binding.getRoot();
    }

    private List<OynatmaPodcastDetayAlti> oynatmaListesi(){

        List<OynatmaPodcastDetayAlti> oynatListe = new ArrayList<>();
        return oynatListe;
    }

}