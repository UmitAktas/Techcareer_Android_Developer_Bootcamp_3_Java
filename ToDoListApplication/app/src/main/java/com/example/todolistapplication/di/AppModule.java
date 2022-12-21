package com.example.todolistapplication.di;

import android.content.Context;

import androidx.room.Room;

import com.example.todolistapplication.data.repo.TodolarDaoRepository;
import com.example.todolistapplication.room.TodolarDao;
import com.example.todolistapplication.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public TodolarDaoRepository provideTodolarDaoRepository(TodolarDao tdao){
        return new TodolarDaoRepository(tdao);
    }

    @Provides
    @Singleton
    public TodolarDao providerTodolarDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context, Veritabani.class, "todolistapp.sqlite").createFromAsset("todolistapp.sqlite").build();
        return vt.getTodolarDao();
    }

}
