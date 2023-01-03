package com.example.doydoy.di;

import com.example.doydoy.data.repo.YemeklerDaoRepository;
import com.example.doydoy.retrofit.ApiUtils;
import com.example.doydoy.retrofit.YemeklerDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public YemeklerDaoRepository provideYemeklerDaoRepository(YemeklerDao ydao){
        return new YemeklerDaoRepository(ydao);
    }

    @Provides
    @Singleton
    public YemeklerDao provideYemeklerDao(){
        return ApiUtils.getYemeklerDao();
    }

}
