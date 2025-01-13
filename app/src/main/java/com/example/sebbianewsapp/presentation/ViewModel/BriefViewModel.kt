package com.example.sebbianewsapp.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.sebbianewsapp.domain.interactor.INewsRepository
import com.example.sebbianewsapp.domain.model.BriefNewsDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class BriefViewModel @Inject constructor(
    private val iNewsRepository: INewsRepository,
) : ViewModel() {

    fun getBrief(id: Long): Flow<PagingData<BriefNewsDomain>> {
        return iNewsRepository.getCategoriesNews(id)
    }

}