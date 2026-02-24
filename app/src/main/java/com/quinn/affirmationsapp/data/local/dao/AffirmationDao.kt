package com.quinn.affirmationsapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.quinn.affirmationsapp.data.local.entity.Affirmation
import kotlinx.coroutines.flow.Flow

@Dao
interface AffirmationDao {
    @Insert
    suspend fun insert(affirmation: Affirmation)

    @Delete
    suspend fun delete(affirmation: Affirmation)

    @Update
    suspend fun updateAffirmation(affirmation: Affirmation)

    @Query("SELECT * FROM affirmations ORDER BY id ASC")
    fun getAllAffirmations(): Flow<List<Affirmation>>

    @Query("DELETE FROM affirmations")
    suspend fun deleteAll()

}
