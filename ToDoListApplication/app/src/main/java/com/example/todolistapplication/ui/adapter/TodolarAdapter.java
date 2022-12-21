package com.example.todolistapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistapplication.R;
import com.example.todolistapplication.data.entity.Todolar;
import com.example.todolistapplication.databinding.CardTasarimiBinding;
import com.example.todolistapplication.ui.fragment.AnasayfaFragmentDirections;
import com.example.todolistapplication.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class TodolarAdapter extends RecyclerView.Adapter<TodolarAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Todolar> todolarListesi;
    private AnasayfaViewModel viewModel;

    public TodolarAdapter(Context mContext, List<Todolar> todolarListesi, AnasayfaViewModel viewModel) {
        this.mContext = mContext;
        this.todolarListesi = todolarListesi;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimiBinding binding;

        public CardTasarimTutucu(CardTasarimiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimiBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarimi, parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Todolar todo = todolarListesi.get(position);
        CardTasarimiBinding t = holder.binding;
        t.setTodoNesnesi(todo);
        t.satirCard.setOnClickListener(view -> {
            AnasayfaFragmentDirections.TodoDetayGecis gecis = AnasayfaFragmentDirections.todoDetayGecis(todo);
            Navigation.findNavController(view).navigate(gecis);
        });

        t.imageViewSil.setOnClickListener(view -> {
            Snackbar.make(view,  "Yapılacak iş silinsin mi?", Snackbar.LENGTH_LONG)
                    .setAction("EVET", view1 -> {
                        viewModel.sil(todo.getTodo_id());
                    }).show();
        });

    }

    @Override
    public int getItemCount() {
        return todolarListesi.size();
    }

}
