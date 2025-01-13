package com.example.sebbianewsapp.domain.interactor

import androidx.paging.PagingData
import com.example.sebbianewsapp.data.NewsApiRepository
import com.example.sebbianewsapp.domain.model.BriefNewsDomain
import com.example.sebbianewsapp.domain.model.BriefResponseNewsDomain
import com.example.sebbianewsapp.domain.model.CategoriesResponseDomain
import com.example.sebbianewsapp.domain.model.DetailsResponseDomain
import kotlinx.coroutines.flow.Flow

import retrofit2.Response
import javax.inject.Inject

class NewsInteractorImpl  @Inject constructor(
    private val newsApiRepository: NewsApiRepository
):INewsRepository{

    override suspend fun getAllCategories(): Response<CategoriesResponseDomain> {
        return newsApiRepository.getAllCategories()
    }

    override  fun getCategoriesNews(id: Long): Flow<PagingData<BriefNewsDomain>> {
        return newsApiRepository.getCategoriesNews(id)
    }

    override suspend fun getNews(id: Long): Response<DetailsResponseDomain> {
        return newsApiRepository.getNews(id)
    }
}