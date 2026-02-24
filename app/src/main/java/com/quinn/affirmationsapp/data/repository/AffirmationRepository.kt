package com.quinn.affirmationsapp.data.repository

import com.quinn.affirmationsapp.data.local.dao.AffirmationDao
import com.quinn.affirmationsapp.data.local.entity.Affirmation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AffirmationRepository @Inject constructor(
    private val dao: AffirmationDao
) {
    suspend fun addAffirmation(affirmationText: String, imagePath: Int) = dao.insert(Affirmation(affirmation = affirmationText, imagePath = imagePath))

    suspend fun removeTask(affirmation: Affirmation)  = dao.delete(affirmation)

    fun readAllAffirmation(): Flow<List<Affirmation>>  = dao.getAllAffirmations()

    suspend fun removeAllAffirmation() = dao.deleteAll()

}