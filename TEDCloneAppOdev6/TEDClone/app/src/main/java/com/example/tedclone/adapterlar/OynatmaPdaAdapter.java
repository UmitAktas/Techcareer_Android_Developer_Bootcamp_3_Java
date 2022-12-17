package com.example.tedclone.adapterlar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tedclone.databinding.OynatmaListesiCardTasarimiBinding;
import com.example.tedclone.databinding.PodcastDetayCardTasarimiBinding;
import com.example.tedclone.entity.OynatmaPodcastDetayAlti;

import java.util.List;

public class OynatmaPdaAdapter extends RecyclerView.Adapter<OynatmaPdaAdapter.CardTasarimTutucusu>{
    private Context mContext;
    private List<OynatmaPodcastDetayAlti> oynatmaListesi;

    public OynatmaPdaAdapter(Context mContext, List<OynatmaPodcastDetayAlti> oynatmaListesi) {
        this.mContext = mContext;
        this.oynatmaListesi = oynatmaListesi;
    }

    public class CardTasarimTutucusu extends RecyclerView.ViewHolder{
        private OynatmaListesiCardTasarimiBinding binding;
        public CardTasarimTutucusu(OynatmaListesiCardTasarimiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucusu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OynatmaListesiCardTasarimiBinding binding = OynatmaListesiCardTasarimiBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new CardTasarimTutucusu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucusu holder, int position) {

        OynatmaPodcastDetayAlti oynat = oynatmaListesi.get(position);
        OynatmaListesiCardTasarimiBinding t = holder.binding;

        t.imageViewPlayResim.setImageResource(mContext.getResources().getIdentifier(oynat.getResimAdi(),"drawable", mContext.getPackageName()));
        t.textViewIcerik.setText(oynat.getIcerik());
        t.textViewSure.setText(oynat.getSure());
        t.textViewTarih.setText(oynat.getTarih());

    }

    @Override
    public int getItemCount() {
        return oynatmaListesi.size();
    }

}
