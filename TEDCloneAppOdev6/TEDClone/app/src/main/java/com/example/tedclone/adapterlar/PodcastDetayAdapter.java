package com.example.tedclone.adapterlar;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tedclone.DetayActivity;
import com.example.tedclone.R;
import com.example.tedclone.databinding.PodcastDetayCardTasarimiBinding;
import com.example.tedclone.entity.PodcastDetay;

import java.net.URISyntaxException;
import java.util.List;

public class PodcastDetayAdapter extends RecyclerView.Adapter<PodcastDetayAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<PodcastDetay> detayListesi;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public PodcastDetayAdapter(Context mContext, List<PodcastDetay> detayListesi) {
        this.mContext = mContext;
        this.detayListesi = detayListesi;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private PodcastDetayCardTasarimiBinding binding;
        private RecyclerView oynatmaRC;
        public CardTasarimTutucu(PodcastDetayCardTasarimiBinding binding, final View oynatmaRC) {
            super(binding.getRoot());
            this.binding = binding;
            this.oynatmaRC = oynatmaRC.findViewById(R.id.rcOynatma);
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PodcastDetayCardTasarimiBinding binding = PodcastDetayCardTasarimiBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new CardTasarimTutucu(binding, binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        PodcastDetay detay = detayListesi.get(position);
        PodcastDetayCardTasarimiBinding t = holder.binding;

        t.imageViewPodcastFoto.setImageResource(mContext.getResources().getIdentifier(detay.getPodcastResim(),"drawable", mContext.getPackageName()));
        t.textViewTamBaslik.setText(detay.getPodcastAdi());
        t.textViewTamAciklama.setText(detay.getPodcastAciklama());
        t.textViewHosted.setText(detay.getPodcastHosted());
        t.textViewMeslek.setText(detay.getHostedMeslek());

        LinearLayoutManager layoutManager = new LinearLayoutManager(t.rcOynatma.getContext(), LinearLayoutManager.VERTICAL,false);
        layoutManager.setInitialPrefetchItemCount(detay.getOynatmaPodcastDetayAltis().size());
        OynatmaPdaAdapter oynatmaPdaAdapter = new OynatmaPdaAdapter(t.rcOynatma.getContext(), detay.getOynatmaPodcastDetayAltis());
        holder.oynatmaRC.setLayoutManager(layoutManager);
        holder.oynatmaRC.setAdapter(oynatmaPdaAdapter);
        holder.oynatmaRC.setRecycledViewPool(viewPool);

    }

    @Override
    public int getItemCount() {
        return detayListesi.size();
    }

}
