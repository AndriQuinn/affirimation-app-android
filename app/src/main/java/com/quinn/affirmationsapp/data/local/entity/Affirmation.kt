package com.quinn.affirmationsapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "affirmations")
data class Affirmation(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val affirmation: String,
    val imagePath: Int
)