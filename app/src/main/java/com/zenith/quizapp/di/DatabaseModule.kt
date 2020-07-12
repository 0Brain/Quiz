package com.zenith.quizapp.di

import android.content.Context
import androidx.room.Room
import com.zenith.quizapp.persistance.QuizDao
import com.zenith.quizapp.persistance.QuizDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):QuizDatabase{
        return Room.databaseBuilder(context,QuizDatabase::class.java,"questions.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(database: QuizDatabase):QuizDao{
        return database.quizDao()
    }
}