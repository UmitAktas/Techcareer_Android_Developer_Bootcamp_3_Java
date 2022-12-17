package com.example.tedclone.adapterlar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tedclone.databinding.AnasayfaTalksOynatmaCardTasarimiBinding;
import com.example.tedclone.databinding.OynatmaListesiCardTasarimiBinding;
import com.example.tedclone.databinding.PodcastTasarimiBinding;
import com.example.tedclone.entity.TalkListesi;
import com.example.tedclone.entity.Talks;

import java.util.List;

public class TalksOynatmaAdapter extends RecyclerView.Adapter<TalksOynatmaAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<TalkListesi> talksList;

    public TalksOynatmaAdapter(Context mContext, List<TalkListesi> talksList) {
        this.mContext = mContext;
        this.talksList = talksList;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private AnasayfaTalksOynatmaCardTasarimiBinding binding;
        public CardTasarimTutucu(AnasayfaTalksOynatmaCardTasarimiBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AnasayfaTalksOynatmaCardTasarimiBinding binding = AnasayfaTalksOynatmaCardTasarimiBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new TalksOynatmaAdapter.CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        TalkListesi talk = talksList.get(position);
        AnasayfaTalksOynatmaCardTasarimiBinding t = holder.binding;

        t.imageViewTalksFoto.setImageResource(mContext.getResources().getIdentifier(talk.getResimAdi(),"drawable", mContext.getPackageName()));
        t.textViewTalksIcerik.setText(talk.getIcerik());
    }

    @Override
    public int getItemCount() {
        return talksList.size();
    }

}
