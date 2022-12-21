package com.example.todolistapplication.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.todolistapplication.data.entity.Todolar;
import com.example.todolistapplication.room.TodolarDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TodolarDaoRepository {

    private MutableLiveData<List<Todolar>> todolarListesi;
    private TodolarDao tdao;

    public TodolarDaoRepository(TodolarDao tdao){
        this.tdao = tdao;
        todolarListesi = new MutableLiveData<>();
    }

    public MutableLiveData<List<Todolar>> getTodolarListesi(){
        return todolarListesi;
    }

    public void todolariYukle(){
        tdao.todolariYukle().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Todolar>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Todolar> todolars) {
                        todolarListesi.setValue(todolars);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void kaydet(String todo_icerik){
        Todolar yeniTodo = new Todolar(0, todo_icerik);
        tdao.kaydet(yeniTodo).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void guncelle(int todo_id, String todo_icerik){
        Todolar guncellenenTodo = new Todolar(todo_id, todo_icerik);
        tdao.guncelle(guncellenenTodo).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void ara(String aramaKelimesi){
        tdao.ara(aramaKelimesi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Todolar>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Todolar> todolars) {
                        todolarListesi.setValue(todolars);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void sil(int todo_id){
        Todolar silinenTodo = new Todolar(todo_id, "");
        tdao.sil(silinenTodo).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        todolariYukle();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
