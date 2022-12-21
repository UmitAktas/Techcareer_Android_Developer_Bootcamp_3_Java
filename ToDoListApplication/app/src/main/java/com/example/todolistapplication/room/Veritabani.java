package com.example.todolistapplication.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.todolistapplication.data.entity.Todolar;

@Database(entities = {Todolar.class}, version = 1)
public abstract class Veritabani extends RoomDatabase {
    public abstract TodolarDao getTodolarDao();
}
