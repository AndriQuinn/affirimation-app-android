package com.quinn.affirmationsapp.viewmodel

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quinn.affirmationsapp.data.local.entity.Affirmation
import com.quinn.affirmationsapp.data.repository.AffirmationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

@HiltViewModel
class AffirmationViewModel @Inject constructor(
    private val repository: AffirmationRepository
): ViewModel() {
    var affimrationText by mutableStateOf("")
        private set

    var affimrationImage by mutableStateOf<String>("")
        private set

    val affirmations: Flow<List<Affirmation>> = repository.readAllAffirmation()

    fun onTextChange(newAffirmationText: String) {
        if (affimrationText.length <= 280) {
            affimrationText = newAffirmationText
        }
    }

    fun saveImageUri(imageUri: String) {
        affimrationImage = imageUri
    }

    fun addTask() {
        viewModelScope.launch {
            repository.addAffirmation(affimrationText, affimrationImage)
        }
    }

    fun removeTask(affirmation: Affirmation) {
        viewModelScope.launch {
            repository.removeTask(affirmation)
        }
    }

    fun copyImage(context: Context, imageUri: Uri, filename: String): String {
        val imageInput = context.contentResolver.openInputStream(imageUri) // Open the byte stream of the image
        val outputDestination =
            File(context.filesDir, "$filename.jpg") // Set the destination for the stream
        val fileOutputDestination =
            FileOutputStream(outputDestination) // Points the byte stream to the file destination
        imageInput?.copyTo(fileOutputDestination) // Copy the image to destination
        fileOutputDestination.flush()
        imageInput?.close()
        fileOutputDestination.close()

        return outputDestination.toString() // Return the directory path ex. data/user... for File() object
    }
}