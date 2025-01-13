package com.example.sebbianewsapp.presentation.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sebbianewsapp.domain.interactor.INewsRepository
import com.example.sebbianewsapp.domain.model.DetailsDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val iNewsRepository: INewsRepository,
) : ViewModel() {


    private val _all = MutableStateFlow<DetailsDomain?>(null)
    val all: StateFlow<DetailsDomain?> get() = _all.asStateFlow()

    fun getDetails(id: Long) = viewModelScope.launch {
        try {
            val response = iNewsRepository.getNews(id)
            if (response.isSuccessful) {
                _all.value = response.body()?.news

            } else {
                Log.d("checkData", "Failed to load details: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.e("DetailsViewModel", "Error fetching details: $e")
        }
    }

}

