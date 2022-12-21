package com.example.todolistapplication.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "toDos")
public class Todolar implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id")
    @NonNull
    private int todo_id;

    @ColumnInfo(name = "todo_icerik")
    @NonNull
    private String todo_icerik;

    public Todolar() {
    }

    public Todolar(int todo_id, @NonNull String todo_icerik) {
        this.todo_id = todo_id;
        this.todo_icerik = todo_icerik;
    }

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    @NonNull
    public String getTodo_icerik() {
        return todo_icerik;
    }

    public void setTodo_icerik(@NonNull String todo_icerik) {
        this.todo_icerik = todo_icerik;
    }
}
