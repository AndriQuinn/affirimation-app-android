package com.quinn.affirmationsapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.quinn.affirmationsapp.data.local.dao.AffirmationDao
import com.quinn.affirmationsapp.data.local.entity.Affirmation


@Database(entities = [Affirmation::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun affirmationsDao(): AffirmationDao
}