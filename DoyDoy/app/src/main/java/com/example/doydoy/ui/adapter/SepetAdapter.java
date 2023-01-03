package com.example.doydoy.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doydoy.R;
import com.example.doydoy.data.entity.SepetYemekler;
import com.example.doydoy.databinding.SepetCardTasarimBinding;
import com.example.doydoy.ui.viewmodel.SepetViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class SepetAdapter extends RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<SepetYemekler> sepetYemeklerListesi;
    private SepetViewModel viewModel;

    public SepetAdapter(Context mContext, List<SepetYemekler> yemeklerListesi, SepetViewModel viewModel) {
        this.mContext = mContext;
        this.sepetYemeklerListesi = yemeklerListesi;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private SepetCardTasarimBinding binding;
        public CardTasarimTutucu(SepetCardTasarimBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SepetCardTasarimBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.sepet_card_tasarim, parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        SepetYemekler yemek = sepetYemeklerListesi.get(position);
        SepetCardTasarimBinding t = holder.binding;

        t.setUrun(yemek);

        viewModel.yemekResimleriniGoster(yemek.getYemek_resim_adi(), t.imageViewUrunSepet);

        t.imageViewSil.setOnClickListener(view -> {
            Snackbar.make(view, yemek.getYemek_adi() + " sepetten çıkarılsın mı?", Snackbar.LENGTH_LONG)
                    .setAction("EVET", view1 -> {
                        viewModel.sepettenSil(yemek.getSepet_yemek_id(),  yemek.getKullanici_adi());
                    }).show();

        });

        ArrayList<Integer> sayilar = new ArrayList<Integer>();
        for (int i = 0; i <= 50; i++){
            sayilar.add(i);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(t.getRoot().getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, sayilar);
        t.spinnerSiparisAdet.setAdapter(adapter);
        t.spinnerSiparisAdet.setSelection(yemek.getYemek_siparis_adet());
        t.spinnerSiparisAdet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Snackbar.make(view, yemek.getYemek_adi() + " sepetten çıkarılsın mı?", Snackbar.LENGTH_LONG)
                            .setAction("EVET", view1 -> {
                                viewModel.sepettenSil(yemek.getSepet_yemek_id(),  yemek.getKullanici_adi());
                            }).show();
                }
                else{
                    yemek.setYemek_siparis_adet(i);
                    t.spinnerSiparisAdet.setSelection(i);
                    t.setUrun(yemek);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return sepetYemeklerListesi.size();
    }

}
