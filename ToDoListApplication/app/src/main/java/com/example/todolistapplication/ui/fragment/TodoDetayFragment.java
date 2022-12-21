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
import com.example.todolistapplication.data.entity.Todolar;
import com.example.todolistapplication.databinding.FragmentTodoDetayBinding;
import com.example.todolistapplication.ui.viewmodel.TodoDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TodoDetayFragment extends Fragment {

    private FragmentTodoDetayBinding binding;
    private TodoDetayViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo_detay, container, false);

        binding.setTodoDetayToolbarBaslik("To Do Detay");

        TodoDetayFragmentArgs bundle = TodoDetayFragmentArgs.fromBundle(getArguments());
        Todolar gelenTodo = bundle.getTodo();
        binding.setTodoNesnesi(gelenTodo);

        binding.setTodoDetayFragment(this);

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(TodoDetayViewModel.class);
    }

    public void guncelle(int todo_id, String todo_icerik){
        viewModel.guncelle(todo_id, todo_icerik);
        View view = getView();
        Navigation.findNavController(view).navigate(R.id.anasayfaFragment);
    }

}