package com.example.todolistapplication.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.todolistapplication.data.repo.TodolarDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TodoKayitViewModel extends ViewModel {

    private TodolarDaoRepository trepo;

    @Inject
    public TodoKayitViewModel(TodolarDaoRepository trepo){
        this.trepo = trepo;
    }

    public void kaydet(String todo_icerik){
        trepo.kaydet(todo_icerik);
    }

}
