package com.example.todolistapplication.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todolistapplication.R;
import com.example.todolistapplication.databinding.FragmentTodoKayitBinding;
import com.example.todolistapplication.ui.viewmodel.TodoKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TodoKayitFragment extends Fragment {

    private FragmentTodoKayitBinding binding;
    private TodoKayitViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo_kayit, container, false);

        binding.setTodoKayitToolbarBaslik("To Do Kayıt");
        binding.setTodoKayitFragment(this);

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(TodoKayitViewModel.class);
    }

    public void kaydet(String todo_icerik){
        viewModel.kaydet(todo_icerik);
        View view = getView();
        Navigation.findNavController(view).navigate(R.id.anasayfaFragment);
    }

}