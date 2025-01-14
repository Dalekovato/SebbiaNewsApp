package com.example.sebbianewsapp.domain.interactor

import androidx.paging.PagingData
import com.example.sebbianewsapp.domain.model.BriefNewsDomain
import com.example.sebbianewsapp.domain.model.CategoriesResponseDomain
import com.example.sebbianewsapp.domain.model.DetailsResponseDomain
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface INewsInteractor {

    suspend fun getAllCategories(): Response<CategoriesResponseDomain>

    fun getCategoriesNews(id: Long): Flow<PagingData<BriefNewsDomain>>

    suspend fun getNews(id: Long): Response<DetailsResponseDomain>

}