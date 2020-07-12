package com.zenith.quizapp.di

import com.zenith.quizapp.persistance.QuizDao
import com.zenith.quizapp.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(quizDao: QuizDao):MainRepository{
        return MainRepository(quizDao)
    }

}