package com.quinn.affirmationsapp

import android.content.Context
import androidx.room.Room
import com.quinn.affirmationsapp.data.local.dao.AffirmationDao
import com.quinn.affirmationsapp.data.local.database.AppDatabase
import com.quinn.affirmationsapp.data.repository.AffirmationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule0 {

    // App Local Database
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext app: Context): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "affirmation_database"
        ).build()
    }

    @Provides
    fun provideAffirmationDao(db: AppDatabase): AffirmationDao {
        return db.affirmationsDao()
    }

    // Provide Task Repository
    @Provides
    @Singleton
    fun provideAffirmationRepository(affirmationDao: AffirmationDao): AffirmationRepository {
        return AffirmationRepository(affirmationDao)
    }
}