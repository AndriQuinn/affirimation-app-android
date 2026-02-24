package com.quinn.affirmationsapp.viewmodel

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
import javax.inject.Inject

@HiltViewModel
class AffirmationViewModel @Inject constructor(
    private val repository: AffirmationRepository
): ViewModel() {

}