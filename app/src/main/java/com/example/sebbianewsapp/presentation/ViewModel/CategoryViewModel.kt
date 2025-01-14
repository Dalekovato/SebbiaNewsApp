package com.example.sebbianewsapp.presentation.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sebbianewsapp.domain.interactor.INewsInteractor
import com.example.sebbianewsapp.domain.model.CategoriesDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val iNewsInteractor: INewsInteractor,
) : ViewModel() {

    private val _all = MutableLiveData<List<CategoriesDomain>>()
    val all: LiveData<List<CategoriesDomain>>
        get() = _all

    init {
        getAllCategories()
    }

    fun getAllCategories() = viewModelScope.launch {
        iNewsInteractor.getAllCategories().let {
            if (it.isSuccessful) {
                _all.postValue(it.body()?.list)
            } else {
                Log.d("checkData", "Failed to load articles: ${it.errorBody()}")
            }

        }
    }

}