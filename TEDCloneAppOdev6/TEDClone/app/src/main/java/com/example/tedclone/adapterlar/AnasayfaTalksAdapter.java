package com.example.tedclone.adapterlar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tedclone.R;
import com.example.tedclone.databinding.AnasayfaCardTasarimiBinding;
import com.example.tedclone.databinding.PodcastDetayCardTasarimiBinding;
import com.example.tedclone.entity.Talks;

import java.util.List;

public class AnasayfaTalksAdapter extends RecyclerView.Adapter<AnasayfaTalksAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Talks> talksListesi;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public AnasayfaTalksAdapter(Context mContext, List<Talks> talksListesi) {
        this.mContext = mContext;
        this.talksListesi = talksListesi;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private AnasayfaCardTasarimiBinding binding;
        private RecyclerView talksRv;
        public CardTasarimTutucu(AnasayfaCardTasarimiBinding binding, final View talksRv) {
            super(binding.getRoot());
            this.binding = binding;
            this.talksRv = talksRv.findViewById(R.id.rvTalks);
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AnasayfaCardTasarimiBinding binding = AnasayfaCardTasarimiBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new AnasayfaTalksAdapter.CardTasarimTutucu(binding, binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        Talks talks = talksListesi.get(position);
        AnasayfaCardTasarimiBinding t = holder.binding;

        t.textViewBaslik.setText(talks.getBaslik());
        t.textViewTed1Baslik.setText(talks.getTed1Baslik());
        t.textViewTed1Icerik.setText(talks.getTed1Icerik());
        t.imageViewTed1.setImageResource(mContext.getResources().getIdentifier(talks.getTed1Resim(),"drawable", mContext.getPackageName()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(t.rvTalks.getContext(), LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setInitialPrefetchItemCount(talks.getTalkListesi().size());
        TalksOynatmaAdapter oynatmaPdaAdapter = new TalksOynatmaAdapter(t.rvTalks.getContext(), talks.getTalkListesi());
        holder.talksRv.setLayoutManager(layoutManager);
        holder.talksRv.setAdapter(oynatmaPdaAdapter);
        holder.talksRv.setRecycledViewPool(viewPool);

    }

    @Override
    public int getItemCount() {
        return talksListesi.size();
    }

}
