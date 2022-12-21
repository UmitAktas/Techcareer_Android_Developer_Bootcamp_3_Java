package com.example.todolistapplication.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todolistapplication.data.entity.Todolar;
import com.example.todolistapplication.data.repo.TodolarDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {

    private TodolarDaoRepository trepo;
    public MutableLiveData<List<Todolar>> todolarListesi = new MutableLiveData<>();

    @Inject
    public AnasayfaViewModel(TodolarDaoRepository trepo){
        this.trepo = trepo;
        todolariYukle();
        todolarListesi = trepo.getTodolarListesi();
    }

    public void ara(String aramaKelimesi){
        trepo.ara(aramaKelimesi);
    }

    public void sil(int todo_id){
        trepo.sil(todo_id);
    }

    public void todolariYukle(){
        trepo.todolariYukle();
    }

}
