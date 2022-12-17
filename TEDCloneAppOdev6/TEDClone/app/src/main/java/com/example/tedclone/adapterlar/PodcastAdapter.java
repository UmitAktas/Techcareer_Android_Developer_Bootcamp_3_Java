package com.example.tedclone.adapterlar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tedclone.DetayActivity;
import com.example.tedclone.databinding.PodcastTasarimiBinding;
import com.example.tedclone.entity.PodcastDetay;

import java.util.List;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.CardTasarimTutucu>{

    private Context mContext;
    private List<PodcastDetay> podcastListesi;

    public PodcastAdapter(Context mContext, List<PodcastDetay> podcastListesi) {
        this.mContext = mContext;
        this.podcastListesi = podcastListesi;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private PodcastTasarimiBinding binding;
        public CardTasarimTutucu(PodcastTasarimiBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PodcastTasarimiBinding binding = PodcastTasarimiBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        PodcastDetay pod = podcastListesi.get(position);
        PodcastTasarimiBinding t = holder.binding;

        t.imageViewPodcast.setImageResource(mContext.getResources()
                .getIdentifier(pod.getPodcastResim(),"drawable", mContext.getPackageName()));
        t.textViewPodcastTarih.setText(pod.getPodcastTarih());
        t.cardViewPodcastListe.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, DetayActivity.class);
            intent.putExtra("nesne", pod);
            mContext.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return podcastListesi.size();
    }
    
}
