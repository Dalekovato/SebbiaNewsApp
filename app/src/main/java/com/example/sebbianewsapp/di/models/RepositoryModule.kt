package com.example.sebbianewsapp.di.models

import com.example.sebbianewsapp.data.NewsApiRepository
import com.example.sebbianewsapp.domain.interactor.INewsRepository
import com.example.sebbianewsapp.domain.interactor.NewsInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideINewsRepository(newsApiRepository: NewsApiRepository):INewsRepository{
        return NewsInteractorImpl(newsApiRepository)
    }
}