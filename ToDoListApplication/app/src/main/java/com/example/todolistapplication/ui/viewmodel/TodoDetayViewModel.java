package com.example.todolistapplication.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.todolistapplication.data.repo.TodolarDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TodoDetayViewModel extends ViewModel {

    private TodolarDaoRepository trepo;

    @Inject
    public TodoDetayViewModel(TodolarDaoRepository trepo){
        this.trepo = trepo;
    }

    public void guncelle(int todo_id, String todo_icerik){
        trepo.guncelle(todo_id, todo_icerik);
    }

}
