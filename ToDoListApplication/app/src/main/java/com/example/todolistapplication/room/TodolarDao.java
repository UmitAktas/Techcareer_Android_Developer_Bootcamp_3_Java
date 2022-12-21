package com.example.todolistapplication.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todolistapplication.data.entity.Todolar;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface TodolarDao {
    @Query("SELECT * FROM toDos")
    Single<List<Todolar>> todolariYukle();

    @Query("SELECT * FROM toDos WHERE todo_icerik like '%' || :aramaKelimesi || '%'")
    Single<List<Todolar>> ara(String aramaKelimesi);

    @Delete
    Completable sil(Todolar todo);

    @Insert
    Completable kaydet(Todolar todo);

    @Update
    Completable guncelle(Todolar todo);

}
