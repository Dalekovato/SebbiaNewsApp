package com.example.sebbianewsapp.domain.interactor

import androidx.paging.PagingData
import com.example.sebbianewsapp.data.dto.ResponseBriefNewsDto
import com.example.sebbianewsapp.data.dto.ResponseCategoriesDto
import com.example.sebbianewsapp.data.dto.ResponseDetailsDto
import com.example.sebbianewsapp.domain.model.BriefNewsDomain
import com.example.sebbianewsapp.domain.model.BriefResponseNewsDomain
import com.example.sebbianewsapp.domain.model.CategoriesResponseDomain
import com.example.sebbianewsapp.domain.model.DetailsResponseDomain
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface INewsRepository {

    suspend fun getAllCategories(): Response<CategoriesResponseDomain>

    fun getCategoriesNews(id: Long): Flow<PagingData<BriefNewsDomain>>

    suspend fun getNews(id: Long): Response<DetailsResponseDomain>

}