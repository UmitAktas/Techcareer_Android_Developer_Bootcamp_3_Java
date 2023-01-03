package com.example.doydoy.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doydoy.R;
import com.example.doydoy.data.entity.Yemekler;
import com.example.doydoy.databinding.YemeklerCardTasarimBinding;
import com.example.doydoy.ui.fragment.YemeklerFragmentDirections;
import com.example.doydoy.ui.viewmodel.YemeklerViewModel;

import java.util.List;

public class YemeklerAdapter extends RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Yemekler> yemeklerListesi;
    private YemeklerViewModel viewModel;

    public YemeklerAdapter(Context mContext, List<Yemekler> yemeklerListesi, YemeklerViewModel viewModel) {
        this.mContext = mContext;
        this.yemeklerListesi = yemeklerListesi;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private YemeklerCardTasarimBinding binding;
        public CardTasarimTutucu(YemeklerCardTasarimBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        YemeklerCardTasarimBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.yemekler_card_tasarim, parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Yemekler yemek = yemeklerListesi.get(position);
        YemeklerCardTasarimBinding t = holder.binding;
        t.setYemekNesnesi(yemek);
        t.yemeklerSatirCard.setOnClickListener(view -> {
            YemeklerFragmentDirections.YemekDetayaGecis gecis = YemeklerFragmentDirections.yemekDetayaGecis(yemek);
            Navigation.findNavController(view).navigate(gecis);
        });

        viewModel.yemekResimleriniGoster(yemek.getYemek_resim_adi(), t.imageViewYemekResim);
    }

    @Override
    public int getItemCount() {
        return yemeklerListesi.size();
    }
}
